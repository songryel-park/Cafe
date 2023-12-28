package com.teamsparta.cafe.exception

import com.teamsparta.cafe.config.ResultCode

abstract class BaseException: RuntimeException() {
    open lateinit var code: ResultCode
    override lateinit var message: String
}