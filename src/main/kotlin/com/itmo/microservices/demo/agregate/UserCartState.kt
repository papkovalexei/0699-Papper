package com.itmo.microservices.demo.agregate

import ru.quipy.core.annotations.DomainEvent
import ru.quipy.core.annotations.StateTransitionFunc
import ru.quipy.domain.AggregateState
import ru.quipy.domain.Event
import java.util.*

const val TAG_ADD_PAPPER = "ADD_PAPPER"
const val TAG_REMOVE_PAPPER = "REMOVE_PAPPER"


class UserCartState: AggregateState<String, UserCart> {
    private lateinit var cartId: String
    private var createdAt: Long = System.currentTimeMillis()
    private var updatedAt: Long = System.currentTimeMillis()
    private var pappers = mutableMapOf<UUID, PappersEntity>()
    private lateinit var userId: UUID
    override fun getId() = cartId

    @StateTransitionFunc
    fun taskAddPaper(event: TagAddPaper) {
        pappers[event.papperId] = PappersEntity(event.papperId, event.namePapper)
        updatedAt = createdAt
    }

    @StateTransitionFunc
    fun taskRemovePaper(event: TagRemovePapper) {
        pappers.remove(event.papperId)
        updatedAt = createdAt
    }
}

data class PappersEntity(
    val id: UUID = UUID.randomUUID(),
    val name: String,
)

@DomainEvent(name = TAG_ADD_PAPPER)
class TagAddPaper(
    val papperId: UUID,
    val namePapper: String,
    createdAt: Long = System.currentTimeMillis(),
) : Event<UserCart>(
    name = TAG_ADD_PAPPER,
    createdAt = createdAt,
)


@DomainEvent(name = TAG_REMOVE_PAPPER)
class TagRemovePapper(
    val papperId: UUID,
    val namePapper: String,
    createdAt: Long = System.currentTimeMillis(),
) : Event<UserCart>(
    name = TAG_REMOVE_PAPPER,
    createdAt = createdAt,
)

fun UserCart.createAddPapper(
    papperId: UUID,
    namePapper: String
): TagAddPaper {
    return TagAddPaper(papperId, namePapper)
}


fun UserCart.createRemovePapper(
    papperId: UUID,
    namePapper: String
): TagRemovePapper {
    return TagRemovePapper(papperId, namePapper)
}