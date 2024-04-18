package com.ngo.service;

import com.ngo.common.ApiResponse;
import com.ngo.common.exception.ConflictException;
import com.ngo.common.exception.NotFoundException;
import com.ngo.common.message.ErrorMessage;
import com.ngo.common.message.SuccessMessage;
import com.ngo.dto.AttDto;
import com.ngo.dto.AttListDto;
import com.ngo.dto.UserDto;
import com.ngo.model.Attendance;
import com.ngo.model.User;
import com.ngo.repository.AttendanceRepository;
import com.ngo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
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

    public ApiResponse<AttDto> postUserAttendance(Long userId)
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.USER_NOT_FOUND));

        LocalDate date = LocalDate.now();

        List<Attendance> userAttList = attendanceRepository.findByUser_UserId(userId).stream()
                .filter(userAtt -> userAtt.getDate().equals(date))
                .toList();

        if (!userAttList.isEmpty())
            throw new ConflictException(ErrorMessage.ATTENDANCE_ALREADY_EXIST);

        Attendance attendance = new Attendance(date, user);
        attendanceRepository.save(attendance);
        return ApiResponse.success(SuccessMessage.POST_USER_ATTENDANCE_SUCCESS, AttDto.build(attendance));

    }
}
