package com.hooba.thisgottawork.users

import jakarta.validation.constraints.NotBlank
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class UsersController(
    private val usersService: UsersService
) {

    @PostMapping("register")
    fun registerUser(@RequestBody request: CreateUserRequest): ResponseEntity<Any> {
        return usersService.registerUser(request)

    }
}

data class CreateUserRequest(
    @field:NotBlank(message = "Username is required")
    val name: String,

    @field:NotBlank(message = "Password is required")
    val age: Int,
    @field:NotBlank(message = "Username is required")
    val username: String,

    @field:NotBlank(message = "Password is required")
    val password: String
)