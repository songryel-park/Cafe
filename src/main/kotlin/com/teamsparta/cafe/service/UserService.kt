package com.teamsparta.cafe.service

import com.teamsparta.cafe.entity.User
import com.teamsparta.cafe.entity.dto.SignUpRequest
import com.teamsparta.cafe.entity.dto.LoginRequest
import com.teamsparta.cafe.exception.DuplicateException
import com.teamsparta.cafe.repository.UserRepository
import com.teamsparta.cafe.security.JwtTokenProvider
import com.teamsparta.cafe.security.TokenInfo
import jakarta.transaction.Transactional
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Transactional
@Service
class UserService(
    private val userRepository: UserRepository,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder,
    private val jwtTokenProvider: JwtTokenProvider,
    private val passwordEncoder: PasswordEncoder
) {
    fun singUp(signUpRequest: SignUpRequest): User {
        val result = userRepository.existsByUsername(signUpRequest.username)
        if (result) {
            throw DuplicateException("중복된 ID입니다")
        }

        val user = signUpRequest.toEntity()
        return userRepository.save(user)
    }

    fun login(loginRequest: LoginRequest): TokenInfo {
        val authenticationToken = UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password)
        val authentication = authenticationManagerBuilder.`object`.authenticate(authenticationToken)

        return jwtTokenProvider.createToken(authentication)
    }

    fun addPoint(userId: Long, point: Long): User {
        val user = userRepository.findById(userId).orElseThrow()
        user.addPoint(point)
        return user
    }
}