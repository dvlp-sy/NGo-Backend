package com.ngo.controller;

import com.ngo.common.ApiResponse;
import com.ngo.dto.AttDto;
import com.ngo.dto.AttListDto;
import com.ngo.dto.UserDto;
import com.ngo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping("/user/{userId}")
    public ApiResponse<UserDto> getUser(@PathVariable("userId") Long userId)
    {
        return userService.getUser(userId);
    }

    @GetMapping("/user/{userId}/attendance")
    public ApiResponse<AttListDto> getUserAttendance(@PathVariable("userId") Long userId)
    {
        return userService.getUserAttendance(userId);
    }

    @PostMapping("/user/{userId}/attendance")
    public ApiResponse<AttDto> postUserAttendance(@PathVariable("userId") Long userId)
    {
        return userService.postUserAttendance(userId);
    }

}
