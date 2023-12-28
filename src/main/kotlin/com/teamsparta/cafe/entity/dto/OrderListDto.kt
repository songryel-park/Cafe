package com.teamsparta.cafe.entity.dto

import com.teamsparta.cafe.entity.Menu
import com.teamsparta.cafe.entity.Order
import com.teamsparta.cafe.entity.OrderList

data class OrderListDto(var menu: Menu, var amount: Long) {
    fun toEntity(order: Order): OrderList {
        return OrderList(order, menu, amount)
    }
}