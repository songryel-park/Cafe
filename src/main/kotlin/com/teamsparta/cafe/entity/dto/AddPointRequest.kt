package com.teamsparta.cafe.entity.dto

import jakarta.validation.constraints.NotNull

data class AddPointRequest(
    @field: NotNull
    var addPoint: Long
)