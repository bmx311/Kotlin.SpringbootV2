package com.hooba.thisgottawork.orders

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.hooba.thisgottawork.items.ItemsEntity
import com.hooba.thisgottawork.users.UserEntity
import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface OrderRepository: JpaRepository<OrderEntity, Long>

@Entity
@Table(name = "orders")
    data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: UserEntity,

    var restaurant: String,

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @JsonManagedReference
    val items: List<ItemsEntity>? = null,
    var timeOrdered: LocalDateTime? = null
){
    constructor() : this(null, UserEntity(), "",null,null)
}