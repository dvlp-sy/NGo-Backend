package com.ngo.common.exception;

import com.ngo.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ControllerExceptionAdvice
{
    /**
     * 404 NOT FOUND
     */

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ApiResponse> NotFoundException(BaseException exception)
    {
        return ResponseEntity.status(NOT_FOUND).body(ApiResponse.error(exception.getError(), exception.getMessage()));
    }


    /**
     * 500 INTERNAL SERVER ERROR
     */

}
