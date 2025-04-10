package com.hooba.thisgottawork.users

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class OrdersController(
    private val ordersService: OrdersService
) {

    @GetMapping("/orders/v1/list")
    fun orders() = ordersService.listOrders()
}