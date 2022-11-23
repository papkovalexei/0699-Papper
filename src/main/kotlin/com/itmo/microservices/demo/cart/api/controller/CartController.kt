package com.itmo.microservices.demo.auth.api.controller

import com.itmo.microservices.demo.checkout.api.model.PickupPointsResult
import com.itmo.microservices.demo.checkout.api.service.CartService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/cart")
class CartController(private val cartService: CartService) {
    @PostMapping("/addPapper/{id}")
    fun addPapper(@PathVariable paperId: UUID) { cartService.addPapper(paperId) }

    @DeleteMapping("/removePapper/{id}")
    fun removePapper(@PathVariable paperId: UUID) { cartService.removePaper(paperId) }
}