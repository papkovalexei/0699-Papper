package com.itmo.microservices.demo.history.api.model

import java.util.Arrays

data class HistoryRequest(
    val historyCard: Array<HistoryCards>
)
