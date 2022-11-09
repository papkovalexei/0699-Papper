package com.itmo.microservices.demo.history.api.model

data class HistoryCards(
    val card: Array<HistoryCard>,
    val trackId: Int,
    val status: String
)
