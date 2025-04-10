package com.hooba.thisgottawork.users


import com.hooba.thisgottawork.OrdersRepository
import jakarta.inject.Named

@Named
class OrdersService(
    private val ordersRepository: OrdersRepository,
) {

    fun listOrders(): List<Order> = ordersRepository.findAll().map {
        Order(
            name = it.name,
            age = it.age
        )
    }
}

data class Order(
    val name: String,
    val age : Int
)
