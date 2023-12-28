package com.teamsparta.cafe.entity.dto

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class MenuDto(
    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String?,

    @Column(name = "image")
    var image: String?,

    @Column(name = "price")
    var price: Long,

    @Column(name = "is_sale")
    var isSale: Boolean,

    @Column(name = "is_sold_out")
    var isSoldOut: Boolean
)

