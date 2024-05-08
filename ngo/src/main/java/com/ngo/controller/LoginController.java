package com.ngo.controller;

import com.ngo.common.ApiResponse;
import com.ngo.dto.LoginFormDto;
import com.ngo.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController
{
    private final LoginService loginService;

    public LoginController(LoginService loginService)
    {
        this.loginService = loginService;
    }

    @PostMapping("/users/login")
    public ApiResponse<Void> loginUser(@RequestBody LoginFormDto loginFormDto, HttpServletRequest request, HttpServletResponse response)
    {
        return loginService.loginUser(loginFormDto, request, response);
    }

    @PostMapping("/users/logout")
    public ApiResponse<Void> logoutUser(HttpServletRequest request, HttpServletResponse response)
    {
        return loginService.logoutUser(request, response);
    }
}
