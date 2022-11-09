package com.itmo.microservices.demo.purchase.api.model

data class PurchaseRequest(
    val papper: Array<Cart>,
    val pickupPoint: Int,
    val CVC: Int,
    val cardNumber: Int,
    val cardOwner: Int
)
