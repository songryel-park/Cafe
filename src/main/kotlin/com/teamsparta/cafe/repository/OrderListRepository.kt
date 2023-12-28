package com.teamsparta.cafe.repository

import com.teamsparta.cafe.entity.OrderList
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderListRepository: JpaRepository<OrderList, Long>