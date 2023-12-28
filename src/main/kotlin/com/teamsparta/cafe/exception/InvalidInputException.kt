package com.teamsparta.cafe.exception

import com.teamsparta.cafe.config.ResultCode

class InvalidInputException(message: String): BaseException() {
    override var code: ResultCode = ResultCode.FORBIDDEN
    override var message: String = message
}