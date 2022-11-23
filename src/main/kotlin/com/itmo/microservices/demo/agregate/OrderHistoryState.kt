package com.itmo.microservices.demo.agregate

import ru.quipy.core.annotations.DomainEvent
import ru.quipy.core.annotations.StateTransitionFunc
import ru.quipy.domain.AggregateState
import ru.quipy.domain.Event
import java.util.*

const val TAG_ORDER_ASSEMBLED = "ORDER_ASSEMBLED"
const val TAG_ORDER_PURCHASED = "ORDER_PURCHASED"
const val TAG_ORDER_DELIVERED = "ORDER_DELIVERED"
const val TAG_ORDER_COMPLETED = "ORDER_COMPLETED"
const val TAG_ORDER_CANCELED = "ORDER_CANCELED"


class OrderHistoryState: AggregateState<String, OrderHistroy> {
    private lateinit var orderId: String
    private var createdAt: Long = System.currentTimeMillis()
    private var updatedAt: Long = System.currentTimeMillis()
    private var orders = mutableMapOf<UUID, OrderEntity>()
    private lateinit var userId: UUID
    override fun getId() = orderId

    @StateTransitionFunc
    fun taskOrderPurchased(event: TagOrderPurchased) {
        orders[event.orderId] = OrderEntity(event.orderId)
        updatedAt = createdAt
    }

    @StateTransitionFunc
    fun taskOrderComleted(event: TagOrderCompleted) {
        orders[event.orderId] = OrderEntity(event.orderId)
        updatedAt = createdAt
    }

    @StateTransitionFunc
    fun taskOrderAssembled(event: TagOrderAssembled) {
        orders[event.orderId] = OrderEntity(event.orderId)
        updatedAt = createdAt
    }

    @StateTransitionFunc
    fun taskOrderDelivered(event: TagOrderDelivered) {
        orders[event.orderId] = OrderEntity(event.orderId)
        updatedAt = createdAt
    }

    @StateTransitionFunc
    fun taskOrderCanceled(event: TagOrderCanceled) {
        orders[event.orderId] = OrderEntity(event.orderId)
        updatedAt = createdAt
    }
}

data class OrderEntity(
    val id: UUID = UUID.randomUUID()
)

@DomainEvent(name = TAG_ORDER_ASSEMBLED)
class TagOrderAssembled(
    val orderId: UUID,
    createdAt: Long = System.currentTimeMillis(),
) : Event<OrderHistroy>(
    name = TAG_ORDER_ASSEMBLED,
    createdAt = createdAt,
)

@DomainEvent(name = TAG_ORDER_COMPLETED)
class TagOrderCompleted(
    val orderId: UUID,
    createdAt: Long = System.currentTimeMillis(),
) : Event<OrderHistroy>(
    name = TAG_ORDER_COMPLETED,
    createdAt = createdAt,
)

@DomainEvent(name = TAG_ORDER_PURCHASED)
class TagOrderPurchased(
    val orderId: UUID,
    createdAt: Long = System.currentTimeMillis(),
) : Event<OrderHistroy>(
    name = TAG_ORDER_PURCHASED,
    createdAt = createdAt,
)

@DomainEvent(name = TAG_ORDER_DELIVERED)
class TagOrderDelivered(
    val orderId: UUID,
    createdAt: Long = System.currentTimeMillis(),
) : Event<OrderHistroy>(
    name = TAG_ORDER_COMPLETED,
    createdAt = createdAt,
)

@DomainEvent(name = TAG_ORDER_CANCELED)
class TagOrderCanceled(
    val orderId: UUID,
    createdAt: Long = System.currentTimeMillis(),
) : Event<OrderHistroy>(
    name = TAG_ORDER_CANCELED,
    createdAt = createdAt,
)

fun OrderHistroy.createCancel(
    orderId: UUID,
): TagOrderCanceled {
    return TagOrderCanceled(orderId)
}

fun OrderHistroy.createCompleted(
    orderId: UUID,
): TagOrderCompleted {
    return TagOrderCompleted(orderId)
}

fun OrderHistroy.createPurchased(
    orderId: UUID,
): TagOrderPurchased {
    return TagOrderPurchased(orderId)
}

fun OrderHistroy.createDelivered(
    orderId: UUID,
): TagOrderDelivered {
    return TagOrderDelivered(orderId)
}

fun OrderHistroy.createAssembled(
    orderId: UUID,
): TagOrderAssembled {
    return TagOrderAssembled(orderId)
}