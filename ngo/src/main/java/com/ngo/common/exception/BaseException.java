package com.ngo.common.exception;

import com.ngo.common.message.ErrorMessage;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException
{
    private final ErrorMessage error;

    public BaseException(ErrorMessage error, String message) {
        super(message);
        this.error = error;
    }

    public int getHttpStatus() {
        return error.getHttpStatusCode();
    }
}
