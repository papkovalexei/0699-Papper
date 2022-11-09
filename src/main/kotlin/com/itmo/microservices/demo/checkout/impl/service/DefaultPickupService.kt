package com.itmo.microservices.demo.checkout.impl.service

import com.itmo.microservices.demo.checkout.api.model.PickupPointsResult
import com.itmo.microservices.demo.checkout.api.service.PickupSercive
import com.itmo.microservices.demo.checkout.impl.entity.MockEntity
import com.itmo.microservices.demo.checkout.impl.entity.PickupEntity
import com.itmo.microservices.demo.checkout.impl.repository.PickupRepository
import com.itmo.microservices.demo.checkout.impl.util.toModel1
import org.springframework.stereotype.Service

@Service
@Suppress("UnstableApiUsage")
class DefaultPickupService(
    private val pickupRepository: PickupRepository
) : PickupSercive {

    override fun getPickupPoints(): PickupPointsResult {
        pushMocksToPero()
        return PickupPointsResult(pickupRepository.findAll().map { it.toModel1() })
    }

    fun pushMocksToPero() {
        pickupRepository.saveAll(MockEntity().allMockEntity)
    }
}