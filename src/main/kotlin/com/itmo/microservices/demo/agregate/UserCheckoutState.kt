package com.itmo.microservices.demo.agregate

import com.itmo.microservices.demo.tasks.api.messaging.TaskCreatedEvent
import ru.quipy.core.annotations.DomainEvent
import ru.quipy.core.annotations.StateTransitionFunc
import ru.quipy.domain.AggregateState
import ru.quipy.domain.Event
import java.util.*

const val TAG_CREATED_CHECKOUT = "CREATE_CHECKOUT"
const val TAG_ADD_PAPPER = "ADD_PAPPER"
const val BANK_ACCOUNT_WITHDRAWAL = "BANK_ACCOUNT_WITHDRAWAL_EVENT"
const val INTERNAL_ACCOUNT_TRANSFER = "INTERNAL_ACCOUNT_TRANSFER_EVENT"

class UserCheckoutState: AggregateState<String, UserCheckout> {
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
) : Event<UserCheckout>(
    name = TAG_CREATED_CHECKOUT,
    createdAt = createdAt,
)

@DomainEvent(name = TAG_ADD_PAPPER)
class TagAddPaper(
    val papperId: UUID,
    val namePapper: String
) : Event<UserCheckout>(
    name = TAG_ADD_PAPPER,
)

fun UserCheckout.createUserCheckout(
): TagCreatedCheckoutEvent {
    return TagCreatedCheckoutEvent()
}

fun UserCheckout.createAddPapper(
    papperId: UUID,
    namePapper: String
): TagAddPaper {
    return TagAddPaper(papperId, namePapper)
}