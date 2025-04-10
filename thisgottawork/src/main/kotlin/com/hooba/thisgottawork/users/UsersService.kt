package com.hooba.thisgottawork.users


import com.hooba.thisgottawork.UsersRepository
import jakarta.inject.Named

@Named
class UsersService(
    private val usersRepository: UsersRepository,
) {

    fun listUsers(): List<User> = usersRepository.findAll().map {
        User(
            name = it.name,
            age = it.age
        )
    }
}

data class User(
    val name: String,
    val age : Int
)
