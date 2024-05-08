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
     * 401 UNAUTHORIZED
     */

    @ExceptionHandler({UnauthorizedException.class})
    public ResponseEntity<ApiResponse> UnauthorizedException(BaseException exception)
    {
        return ResponseEntity.status(UNAUTHORIZED).body(ApiResponse.error(exception.getError(), exception.getMessage()));
    }

    /**
     * 404 NOT FOUND
     */

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ApiResponse> NotFoundException(BaseException exception)
    {
        return ResponseEntity.status(NOT_FOUND).body(ApiResponse.error(exception.getError(), exception.getMessage()));
    }

    /**
     * 409 CONFLICT
     */

    @ExceptionHandler({ConflictException.class})
    public ResponseEntity<ApiResponse> ConflictException(BaseException exception)
    {
        return ResponseEntity.status(CONFLICT).body(ApiResponse.error(exception.getError(), exception.getMessage()));
    }

}
