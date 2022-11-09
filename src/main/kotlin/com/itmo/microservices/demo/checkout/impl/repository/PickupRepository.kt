package com.itmo.microservices.demo.checkout.impl.repository

import com.itmo.microservices.demo.checkout.impl.entity.PickupEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PickupRepository : JpaRepository<PickupEntity, Int>