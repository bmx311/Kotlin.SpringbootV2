package com.hooba.thisgottawork.users

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import jakarta.inject.Named

@Named
interface UserRepository : JpaRepository<UserEntity, Long>{
    fun findByUsername(userName: String): UserEntity?
    fun existsByUsername(username: String): Boolean
}

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val age: Int,
    val username: String,
    val password: String
){
    constructor() : this(null, "",0,"", "")
}