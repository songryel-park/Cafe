package com.teamsparta.cafe.entity

import com.teamsparta.cafe.entity.enums.UserRole
import com.teamsparta.cafe.exception.BadRequestException
import jakarta.persistence.*
import lombok.NoArgsConstructor

@Entity
@NoArgsConstructor
@Table(
    uniqueConstraints = [UniqueConstraint(name = "uk_user_login_id", columnNames = ["loginId"])]
)
class User(username: String, password: String, role: UserRole, point: Long = 0) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "username", unique = true)
    var username: String = username

    @Column(name = "password")
    var password: String = password

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    var role: UserRole = role

    @Column(name = "point")
    var point: Long = point

    fun addPoint(point: Long) {
        this.point += point
    }

    fun lackPoint(point: Long) {
        if (this.point < point) {
            throw BadRequestException("포인트가 부족합니다.")
        }
        this.point -= point
    }
}