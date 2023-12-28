package com.teamsparta.cafe.entity.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class BuyRequest(
    @field:NotEmpty
    var orderLines: List<OrderListDto>,
    @field:NotNull
    var totalPrice: Long,
)