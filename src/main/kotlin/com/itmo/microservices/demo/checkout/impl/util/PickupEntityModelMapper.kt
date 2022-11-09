package com.itmo.microservices.demo.checkout.impl.util

import com.itmo.microservices.demo.checkout.api.model.PickupPointResult
import com.itmo.microservices.demo.checkout.impl.entity.PickupEntity

fun PickupEntity.toModel1(): PickupPointResult = kotlin.runCatching {
    PickupPointResult(
        id = this.id!!,
        address = this.address!!
    )
}.getOrElse { exception -> throw IllegalStateException("Some of point fields are null", exception) }
