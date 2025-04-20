package com.hooba.thisgottawork.orders

import com.hooba.thisgottawork.items.ItemsEntity
import com.hooba.thisgottawork.users.UserRepository
import org.springframework.stereotype.Service


@Service
class OrdersService(
    private val orderRepository: OrderRepository,
    private var userRepository: UserRepository
) {
    fun getOrders(): List<OrderEntity> = orderRepository.findAll().filter { it.user != null }.sortedBy { it.timeOrdered }

    fun addOrder(request: OrderRequest): OrderResponseDTO {
        val user = userRepository.findById(request.userId).orElseThrow {
            IllegalArgumentException("User with ID ${request.userId} not found")
        }

        val order = orderRepository.save(
            OrderEntity(
                user = user,
                restaurant = request.restaurant
            )
        )

        val items = request.items.map { item ->
            ItemsEntity(
                order = order,
                name = item.name,
                price = item.price
            )
        }

        return OrderResponseDTO(
            id = order.id!!,
            username = user.username,
            restaurant = order.restaurant,
            timeOrdered = order.timeOrdered.toString(),
            items = items.map {
                RequestItem(name = it.name, price = it.price)
            }
        )
    }
}