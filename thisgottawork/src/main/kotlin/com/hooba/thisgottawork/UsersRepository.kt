package com.hooba.thisgottawork

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository : JpaRepository<Order, Long>

@Entity
@Table(name = "orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "name")
    val name: String,
    @Column(name = "restaurant")
    val restaurant: String,
   // val items: MutableList<String>
){
    constructor() : this(null, "","")
}