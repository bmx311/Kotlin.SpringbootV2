package com.hooba.thisgottawork

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController(
    val usersRepository: UsersRepository,
    val orderRepository: OrdersRepository
){

    @GetMapping("/home")
    fun helloWorld() =  "Welcome to online ordering!"


    @PostMapping("/add-name")
    fun sayMyName( @RequestBody request: SayMyNameRequest)
    = usersRepository.save(UserEntity(id =request.id,name = request.name, age = request.age))

    @PostMapping("/add-order")
    fun sayMyOrder( @RequestBody request: SayMyOrderRequest)
    = orderRepository.save(OrderEntity(id =request.id,name = request.name, age = request.age))
}

data class SayMyNameRequest(
    val id: Long?,
    val name: String,
    val age: Int
)
data class SayMyOrderRequest(
    val id: Long?,
    val name: String,
    val age: Int
)