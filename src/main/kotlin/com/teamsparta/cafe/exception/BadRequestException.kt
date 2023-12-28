package com.teamsparta.cafe.exception

import com.teamsparta.cafe.config.ResultCode

class BadRequestException(message: String): BaseException() {
    override var code: ResultCode = ResultCode.BAD_REQUEST
    override var message: String = message
}