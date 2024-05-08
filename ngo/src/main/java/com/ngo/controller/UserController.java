package com.ngo.controller;

import com.ngo.common.ApiResponse;
import com.ngo.dto.*;
import com.ngo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController
{
    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    /**
     * 회원가입
     */

    @PostMapping("/users/register")
    public ApiResponse<RegisterDto> registerUser(@RequestBody RegisterDto registerDto)
    {
        return userService.registerUser(registerDto);
    }

    /**
     * 유저 정보 관리
     */
    @GetMapping("/users/{userId}")
    public ApiResponse<UserDto> getUser(@PathVariable("userId") Long userId)
    {
        return userService.getUser(userId);
    }

    @PatchMapping("/users/{userId}/level")
    public ApiResponse<UserLevelDto> patchUserLevel(@PathVariable("userId") Long userId, @RequestBody UserLevelDto userLevelDto)
    {
        return userService.patchUserLevel(userId, userLevelDto);
    }

    /**
     * 출석 정보 관리
     */

    @GetMapping("/users/{userId}/attendances")
    public ApiResponse<AttListDto> getUserAttendance(@PathVariable("userId") Long userId)
    {
        return userService.getUserAttendance(userId);
    }

    @GetMapping("users/{userId}/recentAttendances")
    public ApiResponse<AttListDto> getRecentAttendance(@PathVariable("userId") Long userId)
    {
        return userService.getRecentAttendance(userId);
    }

    @PostMapping("/users/{userId}/attendances")
    public ApiResponse<AttDto> postUserAttendance(@PathVariable("userId") Long userId)
    {
        return userService.postUserAttendance(userId);
    }

}
