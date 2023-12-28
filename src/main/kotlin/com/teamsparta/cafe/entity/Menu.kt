package com.teamsparta.cafe.entity

import com.teamsparta.cafe.exception.BadRequestException
import jakarta.persistence.*

@Entity
@Table(name = "menu")
class Menu(menuId: Long? = null, name: String, description: String, price: Long, amount: Long) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val menuId: Long? = menuId

    @Column(name = "name")
    var name = name

    @Column(name = "description")
    var description = description

    @Column(name = "price")
    var price = price

    @Column(name = "amount")
    var amount = amount

    @Column(name = "sale_count")
    var saleCount: Long = 0

    fun stock(amount: Long) {
        if (this.amount < amount) {
            throw BadRequestException("품절입니다")
        }
        this.amount -= amount
        this.saleCount += amount
    }
}