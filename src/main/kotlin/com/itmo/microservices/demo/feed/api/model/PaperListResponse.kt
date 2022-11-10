package com.itmo.microservices.demo.feed.api.model

data class PaperListResponse(
    val cards: Array<CardResponse>,
    val filters: Array<String>
)