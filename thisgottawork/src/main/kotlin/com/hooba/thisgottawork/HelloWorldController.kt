package com.hooba.thisgottawork

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController(
    val usersRepository: UsersRepository
){

    @GetMapping("/home")
    fun helloWorld() =  "Welcome to online ordering!"


    @PostMapping("/order")
    fun saveMyOrder( @RequestBody request: MyOrderRequest) =
        usersRepository.save(Order(name = request.name, restaurant = request.restaurant, items = request.items))

}

data class MyOrderRequest(
    val id: Long?,
    val name: String,
    val restaurant: String,
    val items: MutableList<String>
)