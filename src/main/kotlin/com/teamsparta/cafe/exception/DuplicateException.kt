package com.teamsparta.cafe.exception

import com.teamsparta.cafe.config.ResultCode

class DuplicateException(message: String): BaseException() {
    override var code: ResultCode = ResultCode.DUPLICATE_ENTITY
    override var message: String = message
}