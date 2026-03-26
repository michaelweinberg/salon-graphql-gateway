package com.salon.gateway.domain

data class CreateOrderResponse(
    val status: Int,
    val message: String,
    val order: Order
)
