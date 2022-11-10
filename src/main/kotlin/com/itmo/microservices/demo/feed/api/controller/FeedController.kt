package com.itmo.microservices.demo.auth.api.controller

import com.itmo.microservices.demo.auth.api.model.AuthenticationRequest
import com.itmo.microservices.demo.auth.api.model.AuthenticationResult
import com.itmo.microservices.demo.auth.api.service.AuthService
import com.itmo.microservices.demo.feed.api.model.PaperListResponse
import com.itmo.microservices.demo.feed.api.service.FeedService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/feed")
class FeedController(private val feedService: FeedService) {

    @GetMapping("/list_paper")
    fun getPaperCatalog(): PaperListResponse =
        feedService.getPaperCatalog()
}
