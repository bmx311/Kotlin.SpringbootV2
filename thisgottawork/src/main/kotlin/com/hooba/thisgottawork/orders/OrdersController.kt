package com.hooba.thisgottawork.orders

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrdersController(
    private val ordersService: OrdersService
) {

    @GetMapping("/orders")
    fun getOrders() = ordersService.getOrders()

    @PostMapping("/orders")
    fun addOrder(@RequestBody request: OrderRequest) =
        ordersService.addOrder(request)
}



// the DTO (Data Transfer Object) for our orders and items list
data class RequestItem(
    val name: String,
    val price: Double
)

data class OrderRequest(
    val userId: Long,
    val restaurant: String,
    val items: List<RequestItem>
)

data class OrderResponseDTO(
    val id: Long,
    val username: String,
    val restaurant: String,
    val items: List<RequestItem>,
    val timeOrdered: String?
)