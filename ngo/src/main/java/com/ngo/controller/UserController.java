package com.ngo.controller;

import com.ngo.common.ApiResponse;
import com.ngo.dto.requestDto.LoginPwDto;
import com.ngo.dto.requestDto.RegisterDto;
import com.ngo.dto.requestDto.UserLevelDto;
import com.ngo.dto.responseDto.AttDto;
import com.ngo.dto.responseDto.AttListDto;
import com.ngo.dto.responseDto.UserDto;
import com.ngo.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * ==== User Controller for User and Attendance Information Management ====
 * @package : com.ngo.controller
 * @name : UserController.java
 * @date : 2024. 04. 16.
 * @author : siyunsmacbook
*/

@RestController
@RequestMapping("/api")
public class UserController
{
    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    /**
     * 회원가입 및 회원탈퇴
     */

    @PostMapping("/users/register")
    public ApiResponse<Void> registerUser(@RequestBody RegisterDto registerDto)
    {
        return userService.registerUser(registerDto);
    }

    @DeleteMapping("/users/{userId}/withdrawal")
    public ApiResponse<Void> withdrawalUser(@PathVariable("userId") Long userId)
    {
        return userService.withdrawalUser(userId);
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

    @PatchMapping("/users/{userId}/pw")
    public ApiResponse<Void> patchUserPw(@PathVariable("userId") Long userId, @RequestBody LoginPwDto loginPwDto)
    {
        return userService.patchUserPw(userId, loginPwDto);
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
