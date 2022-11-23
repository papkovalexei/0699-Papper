package com.itmo.microservices.demo.agregate

import ru.quipy.core.annotations.DomainEvent
import ru.quipy.core.annotations.StateTransitionFunc
import ru.quipy.domain.AggregateState
import ru.quipy.domain.Event
import java.util.*

const val TAG_CREATED_CHECKOUT = "CREATE_CHECKOUT"
const val TAG_ADD_PAPPER = "ADD_PAPPER"


class UserCartState: AggregateState<String, UserCart> {
    private lateinit var trackId: String
    private var createdAt: Long = System.currentTimeMillis()
    private var updatedAt: Long = System.currentTimeMillis()
    private var pappers = mutableMapOf<UUID, PappersEntity>()
    private lateinit var userId: UUID
    override fun getId() = trackId

    @StateTransitionFunc
    fun tagCreatedApply(event: TagCreatedCheckoutEvent) {
        updatedAt = createdAt
    }

    @StateTransitionFunc
    fun taskCreatedApply(event: TagAddPaper) {
        pappers[event.papperId] = PappersEntity(event.papperId, event.namePapper)
        updatedAt = createdAt
    }
}

data class PappersEntity(
    val id: UUID = UUID.randomUUID(),
    val name: String,
)

@DomainEvent(name = TAG_CREATED_CHECKOUT)
class TagCreatedCheckoutEvent(
    createdAt: Long = System.currentTimeMillis(),
) : Event<UserCart>(
    name = TAG_CREATED_CHECKOUT,
    createdAt = createdAt,
)

@DomainEvent(name = TAG_ADD_PAPPER)
class TagAddPaper(
    val papperId: UUID,
    val namePapper: String
) : Event<UserCart>(
    name = TAG_ADD_PAPPER,
)

fun UserCart.createUserCheckout(
): TagCreatedCheckoutEvent {
    return TagCreatedCheckoutEvent()
}

fun UserCart.createAddPapper(
    papperId: UUID,
    namePapper: String
): TagAddPaper {
    return TagAddPaper(papperId, namePapper)
}