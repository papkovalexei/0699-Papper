package com.itmo.microservices.demo.agregate

import ru.quipy.core.annotations.AggregateType
import ru.quipy.domain.Aggregate

@AggregateType(aggregateEventsTableName = "aggregate-cart")
class UserCart: Aggregate