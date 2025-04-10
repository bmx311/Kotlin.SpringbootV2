package com.hooba.thisgottawork

import jakarta.inject.Named
import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository

@Named
interface UsersRepository : JpaRepository<Order, Long>

@Entity
@Table(name = "orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val restaurant: String,
    val items: MutableList<String>
){
    constructor() : this(null, "","", mutableListOf())
}