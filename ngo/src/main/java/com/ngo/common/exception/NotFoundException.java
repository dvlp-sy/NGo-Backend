package com.ngo.common.exception;
import com.ngo.common.message.ErrorMessage;
import lombok.Getter;

@Getter
public class NotFoundException extends BaseException
{
    public NotFoundException(ErrorMessage error) {
        super(error, "[NotFoundException] "+ error.getMessage());
    }

}
