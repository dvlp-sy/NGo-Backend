package com.ngo.service;

import com.ngo.common.ApiResponse;
import com.ngo.common.exception.ConflictException;
import com.ngo.common.exception.NotFoundException;
import com.ngo.common.message.ErrorMessage;
import com.ngo.common.message.SuccessMessage;
import com.ngo.dto.*;
import com.ngo.model.Attendance;
import com.ngo.model.User;
import com.ngo.repository.AttendanceRepository;
import com.ngo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

    /**
     * 회원가입
     */

    public ApiResponse<RegisterDto> registerUser(RegisterDto registerDto)
    {
        User user = User.build(registerDto);
        userRepository.save(user);
        return ApiResponse.success(SuccessMessage.REGISTER_USER_SUCCESS);
    }

    /**
     * 유저 정보 관리
     */

    public ApiResponse<UserDto> getUser(Long userId)
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.USER_NOT_FOUND));
        return ApiResponse.success(SuccessMessage.GET_USER_SUCCESS, UserDto.build(user));
    }

    public ApiResponse<UserLevelDto> patchUserLevel(Long userId, UserLevelDto userLevelDto)
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.USER_NOT_FOUND));

        user.setLevel(userLevelDto.getLevel());
        userRepository.save(user);

        return ApiResponse.success(SuccessMessage.PATCH_USER_LEVEL_SUCCESS, userLevelDto);
    }

    /**
     * 출석 정보 관리
     */

    public ApiResponse<AttListDto> getUserAttendance(Long userId)
    {
        userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.USER_NOT_FOUND));

        List<AttDto> attDtoList = attendanceRepository.findByUser_UserId(userId).stream()
                .map(AttDto::build)
                .toList();

        return ApiResponse.success(SuccessMessage.GET_USER_ATTENDANCE_SUCCESS, new AttListDto(userId, attDtoList));
    }

    public ApiResponse<AttListDto> getRecentAttendance(Long userId)
    {
        userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.USER_NOT_FOUND));

        /* today's date */
        LocalDate date = LocalDate.now();
        List<LocalDate> recentDateList = new ArrayList<>();

        /* recent week date */
        for (int day=0; day<7; day++)
        {
            date = date.minusDays(day);
            recentDateList.add(date);
        }

        System.out.println(recentDateList);

        List<AttDto> attDtoList = attendanceRepository.findByUser_UserId(userId).stream()
                .filter(attendance -> {
                    LocalDate attendanceDate = attendance.getDate();
                    for (LocalDate recentDate : recentDateList)
                    {
                        if (attendanceDate.equals(recentDate))
                            return true;
                    }
                    return false;
                })
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
