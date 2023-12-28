package com.teamsparta.cafe.exception

import com.teamsparta.cafe.config.ResultCode

class NotFoundException(message: String): BaseException() {
    override var code: ResultCode = ResultCode.NOT_FOUND
    override var message: String = message
}