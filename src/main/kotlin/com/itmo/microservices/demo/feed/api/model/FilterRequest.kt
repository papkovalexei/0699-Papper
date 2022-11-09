package com.itmo.microservices.demo.feed.api.model

data class FilterRequest(
    val minCost: Int,
    val maxCost: String,
    val typePaper: Array<String>,
    val color: Array<String>,
    val companyPapper: Array<String>
)