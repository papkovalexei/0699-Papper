package com.itmo.microservices.demo.checkout.api.service

import com.itmo.microservices.demo.checkout.api.model.PickupPointsResult

interface PickupSercive {
    fun getPickupPoints(): PickupPointsResult
}