package com.salon.gateway.domain

data class OrderInput(
    val id: Int?,
    val customer: String,
    val service: String,
    val status: String?,
    val appointmentTime: String
)
