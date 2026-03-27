package com.salon.gateway.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {

    @Bean
    fun orderServiceWebClient(
        @Value("\${order-service.base-url}") baseUrl: String
    ): WebClient = WebClient.builder().baseUrl(baseUrl).build()

    @Bean
    fun inventoryServiceWebClient(
        @Value("\${inventory-service.base-url}") baseUrl: String
    ): WebClient = WebClient.builder().baseUrl(baseUrl).build()
}
