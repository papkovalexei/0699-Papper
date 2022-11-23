package com.itmo.microservices.demo.feed.api.model

import java.util.*

data class CardResponse(
    val id: Int? = null,
    val name: String,
    val description: String,
    val count: Int,
    val cost: Int
)