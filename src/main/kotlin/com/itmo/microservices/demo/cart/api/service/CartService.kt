package com.itmo.microservices.demo.checkout.api.service

import com.itmo.microservices.demo.checkout.api.model.PickupPointsResult
import java.util.*

interface CartService {
    fun addPapper(id: UUID)
    fun removePaper(id: UUID)
}