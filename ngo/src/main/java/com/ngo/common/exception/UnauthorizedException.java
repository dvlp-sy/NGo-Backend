package com.ngo.common.exception;

import com.ngo.common.message.ErrorMessage;
import lombok.Getter;

@Getter
public class UnauthorizedException extends BaseException
{
    public UnauthorizedException(ErrorMessage error) {
        super(error, "[UnauthorizedException] "+ error.getMessage());
    }
}
