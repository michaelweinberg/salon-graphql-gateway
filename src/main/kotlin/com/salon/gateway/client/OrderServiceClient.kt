package com.salon.gateway.client

import com.salon.gateway.domain.CreateOrderResponse
import com.salon.gateway.domain.Order
import com.salon.gateway.domain.OrderInput
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Component
class OrderServiceClient(private val orderServiceWebClient: WebClient) {

    suspend fun getOrder(id: Int): Order =
        orderServiceWebClient.get()
            .uri("/orders/{id}", id)
            .retrieve()
            .awaitBody()

    suspend fun createOrder(input: OrderInput): CreateOrderResponse =
        orderServiceWebClient.post()
            .uri("/orders")
            .bodyValue(input)
            .retrieve()
            .awaitBody()
}
