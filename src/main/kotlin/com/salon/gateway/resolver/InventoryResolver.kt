package com.salon.gateway.resolver

import com.salon.gateway.client.InventoryServiceClient
import com.salon.gateway.domain.InventoryItem
import com.salon.gateway.domain.InventoryItemInput
import com.salon.gateway.domain.InventoryResponse
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class InventoryResolver(private val inventoryServiceClient: InventoryServiceClient) {

    @QueryMapping
    suspend fun inventoryItem(@Argument id: String): InventoryItem =
        inventoryServiceClient.getInventoryItem(id)

    @MutationMapping
    suspend fun addInventoryItem(@Argument input: InventoryItemInput): InventoryResponse =
        inventoryServiceClient.addInventoryItem(input)
}
