package com.ngo.service;

import com.ngo.common.ApiResponse;
import com.ngo.common.exception.NotFoundException;
import com.ngo.common.message.ErrorMessage;
import com.ngo.common.message.SuccessMessage;
import com.ngo.dto.AttDto;
import com.ngo.dto.AttListDto;
import com.ngo.dto.UserDto;
import com.ngo.model.User;
import com.ngo.repository.AttendanceRepository;
import com.ngo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService
{
    private final UserRepository userRepository;
    private final AttendanceRepository attendanceRepository;

    public UserService(UserRepository userRepository, AttendanceRepository attendanceRepository)
    {
        this.userRepository = userRepository;
        this.attendanceRepository = attendanceRepository;
    }

    public ApiResponse<UserDto> getUser(Long userId)
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.USER_NOT_FOUND));
        return ApiResponse.success(SuccessMessage.GET_USER_SUCCESS, UserDto.build(user));
    }

    public ApiResponse<AttListDto> getUserAttendance(Long userId)
    {
        userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.USER_NOT_FOUND));

        List<AttDto> attDtoList = attendanceRepository.findByUser_UserId(userId).stream()
                .map(AttDto::build)
                .toList();

        return ApiResponse.success(SuccessMessage.GET_USER_ATTENDANCE_SUCCESS, new AttListDto(userId, attDtoList));
    }
}
