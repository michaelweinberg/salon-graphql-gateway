package com.salon.gateway.client

import com.salon.gateway.domain.InventoryItem
import com.salon.gateway.domain.InventoryItemInput
import com.salon.gateway.domain.InventoryResponse
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Component
class InventoryServiceClient(private val inventoryServiceWebClient: WebClient) {

    suspend fun getInventoryItem(id: String): InventoryItem =
        inventoryServiceWebClient.get()
            .uri("/inventory/{id}", id)
            .retrieve()
            .awaitBody()

    suspend fun addInventoryItem(input: InventoryItemInput): InventoryResponse =
        inventoryServiceWebClient.post()
            .uri("/inventory")
            .bodyValue(input)
            .retrieve()
            .awaitBody()
}
