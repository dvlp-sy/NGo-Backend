package com.ngo.controller;

import com.ngo.common.ApiResponse;
import com.ngo.dto.AttDto;
import com.ngo.dto.AttListDto;
import com.ngo.dto.UserDto;
import com.ngo.dto.UserLevelDto;
import com.ngo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController
{
    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    /**
     * 유저 정보 관리
     */
    @GetMapping("/user/{userId}")
    public ApiResponse<UserDto> getUser(@PathVariable("userId") Long userId)
    {
        return userService.getUser(userId);
    }

    @PatchMapping("/user/{userId}/level")
    public ApiResponse<UserLevelDto> patchUserLevel(@PathVariable("userId") Long userId, @RequestBody UserLevelDto userLevelDto)
    {
        return userService.patchUserLevel(userId, userLevelDto);
    }

    /**
     * 출석 정보 관리
     */

    @GetMapping("/user/{userId}/attendance")
    public ApiResponse<AttListDto> getUserAttendance(@PathVariable("userId") Long userId)
    {
        return userService.getUserAttendance(userId);
    }

    @GetMapping("user/{userId}/recentAttendance")
    public ApiResponse<AttListDto> getRecentAttendance(@PathVariable("userId") Long userId)
    {
        return userService.getRecentAttendance(userId);
    }

    @PostMapping("/user/{userId}/attendance")
    public ApiResponse<AttDto> postUserAttendance(@PathVariable("userId") Long userId)
    {
        return userService.postUserAttendance(userId);
    }

}
