package com.teamsparta.cafe.entity

import jakarta.persistence.*

@Entity
@Table(name = "orders")
class Order(totalPrice: Long): Time() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderId: Long? = null

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], orphanRemoval = true)
    var orderList: MutableList<OrderList> = ArrayList()

    @Column(name = "total_price")
    var totalPrice = totalPrice

    fun addOrder(orderList: OrderList) {
        this.orderList.add(orderList)
    }
}