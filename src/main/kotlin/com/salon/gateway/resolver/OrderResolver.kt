package com.salon.gateway.resolver

import com.salon.gateway.client.OrderServiceClient
import com.salon.gateway.domain.CreateOrderResponse
import com.salon.gateway.domain.Order
import com.salon.gateway.domain.OrderInput
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class OrderResolver(private val orderServiceClient: OrderServiceClient) {

    @QueryMapping
    suspend fun order(@Argument id: Int): Order =
        orderServiceClient.getOrder(id)

    @MutationMapping
    suspend fun createOrder(@Argument input: OrderInput): CreateOrderResponse =
        orderServiceClient.createOrder(input)
}
