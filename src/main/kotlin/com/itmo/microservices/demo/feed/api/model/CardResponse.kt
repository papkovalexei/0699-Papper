package com.itmo.microservices.demo.feed.api.model

data class CardResponse(
    val id: Int,
    val name: String,
    val description: String,
    val count: Int,
    val cost: Double
)