package com.teamsparta.cafe.entity

import jakarta.persistence.*

@Entity
@Table(name = "orderList")
class OrderList(order: Order, menu: Menu, amount: Long) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val listId: Long? = null

    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "orderId", nullable = false)
    var order: Order = order

    @ManyToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinColumn(name = "menuId", nullable = false)
    var menu = menu

    @Column(name = "amount")
    var amount = amount
}