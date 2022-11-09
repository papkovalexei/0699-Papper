package com.itmo.microservices.demo.history.api.model

data class HistoryCard(
    val id: Int,
    val name: String,
    val description: String,
    val count: Int,
    val cost: Double
)