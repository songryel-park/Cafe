package com.teamsparta.cafe.exception

import com.teamsparta.cafe.config.ResultCode

class JwtException(
    override var code: ResultCode = ResultCode.UNAUTHORIZED,
    override var message: String
): BaseException()