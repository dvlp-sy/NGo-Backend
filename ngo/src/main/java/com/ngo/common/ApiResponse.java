package com.ngo.common;

import com.ngo.common.message.ErrorMessage;
import com.ngo.common.message.SuccessMessage;
import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T>
{
    private final int status;
    private final String message;
    private T data;

    private ApiResponse() { throw new IllegalStateException(); }

    public static <T> ApiResponse<T> success(SuccessMessage successMessage)
    {
        return new ApiResponse<>(successMessage.getHttpStatusCode(), successMessage.getMessage());
    }

    public static <T> ApiResponse<T> success(SuccessMessage successMessage, T data)
    {
        return new ApiResponse<>(successMessage.getHttpStatusCode(), successMessage.getMessage(), data);
    }

    public static <T> ApiResponse<T> error(ErrorMessage error)
    {
        return new ApiResponse<>(error.getHttpStatusCode(), error.getMessage());
    }

    public static <T> ApiResponse<T> error(ErrorMessage error, @Nullable String message)
    {
        return new ApiResponse<>(error.getHttpStatusCode(), message);
    }

    public static <T> ApiResponse<T> error(ErrorMessage error, @Nullable String message, @Nullable T data)
    {
        return new ApiResponse<>(error.getHttpStatusCode(), message, data);
    }
}
