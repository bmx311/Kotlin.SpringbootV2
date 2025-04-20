package com.hooba.thisgottawork

import com.hooba.thisgottawork.users.UserEntity
import com.hooba.thisgottawork.users.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController(
    val usersRepository: UserRepository,
){

    @GetMapping("/home")
    fun helloWorld() =  "Welcome to online ordering!"


    @PostMapping("/add-name")
    fun sayMyName( @RequestBody request: SayMyNameRequest)
    = usersRepository.save(
        UserEntity(
        id =request.id,
        name = request.name,
        age = request.age,
        username = request.username,
        password = request.password
    )
    )

}

data class SayMyNameRequest(
    val id: Long?,
    val name: String,
    val age: Int,
    val username: String,
    val password: String
)
