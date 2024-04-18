package com.ngo.common.exception;
import com.ngo.common.message.ErrorMessage;
import lombok.Getter;

@Getter
public class ConflictException extends BaseException
{
    public ConflictException(ErrorMessage error) {
        super(error, "[ConflictException] "+ error.getMessage());
    }

}
