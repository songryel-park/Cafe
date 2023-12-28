package com.teamsparta.cafe.controller

import com.teamsparta.cafe.config.Response
import com.teamsparta.cafe.entity.dto.AddPointRequest
import com.teamsparta.cafe.entity.dto.LoginRequest
import com.teamsparta.cafe.entity.dto.SignUpRequest
import com.teamsparta.cafe.security.TokenInfo
import com.teamsparta.cafe.service.UserService
import jakarta.validation.Valid
import lombok.RequiredArgsConstructor
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.User
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
class UserController(private val userService: UserService) {
    @PostMapping("/signup")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): Response<Unit> {
        val resultMsg = userService.singUp(signUpRequest)
        return Response(resultMsg)
    }

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): Response<TokenInfo> {
        val tokenInfo = userService.login(loginRequest)
        return Response(data = tokenInfo)
    }

    @PostMapping("/addPoint")
    fun addPoint(
        @AuthenticationPrincipal user: User,
        @Valid @RequestBody addPointRequest: AddPointRequest): Response<Unit> {
        val userPoint = userService.addPoint(user.username.toLong(), addPointRequest.addPoint)
        return Response(userPoint)
    }
}