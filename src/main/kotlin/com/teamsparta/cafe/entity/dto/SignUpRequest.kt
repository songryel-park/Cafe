package com.teamsparta.cafe.entity.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.teamsparta.cafe.entity.User
import com.teamsparta.cafe.entity.enums.UserRole
import com.teamsparta.cafe.exception.BadRequestException
import jakarta.validation.constraints.NotBlank
import org.springframework.boot.autoconfigure.security.SecurityProperties

data class SignUpRequest(
    var userId: Long?,

    @field:NotBlank
    @JsonProperty("username")
    var username: String,

    @field:NotBlank
    @JsonProperty("password")
    var password: String,

    @field:NotBlank
    @JsonProperty("role")
    var role: String,

    @JsonProperty("point")
    var point: Long = 0
) {
    val user = User(
        username = username,
        password = password,
        role = when (role) {
            "USER" -> UserRole.ROLE_USER
            "ADMIN" -> UserRole.ROLE_ADMIN
            else -> throw BadRequestException("유효하지 않은 권한입니다.")
        },
        point = point
    )

    fun toEntity(): User = User(userId, username, password, role, point)
}