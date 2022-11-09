package com.itmo.microservices.demo.auth.api.controller

import com.itmo.microservices.demo.auth.api.model.AuthenticationRequest
import com.itmo.microservices.demo.auth.api.model.AuthenticationResult
import com.itmo.microservices.demo.auth.api.service.AuthService
import com.itmo.microservices.demo.checkout.api.model.PickupPointsResult
import com.itmo.microservices.demo.checkout.api.service.PickupSercive
import com.itmo.microservices.demo.users.api.model.AppUserModel
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.security.core.Authentication
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/checkout")
class PickupPointsController(private val pickupSercive: PickupSercive) {

    @GetMapping
    @Operation(
        summary = "Get current user info",
        responses = [
            ApiResponse(description = "OK", responseCode = "200"),
            ApiResponse(description = "Pickups not found", responseCode = "400", content = [Content()])
        ]
    )
    fun getPickupPoints(): PickupPointsResult = pickupSercive.getPickupPoints()
}