package com.ngo.service;

import com.ngo.common.ApiResponse;
import com.ngo.common.exception.NotFoundException;
import com.ngo.common.message.ErrorMessage;
import com.ngo.common.message.SuccessMessage;
import com.ngo.dto.ScoreDto;
import com.ngo.model.User;
import com.ngo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService {
    private final UserRepository userRepository;

    public RankService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApiResponse<ScoreDto> patchScore(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.USER_NOT_FOUND));

        user.setDayScore(user.getDayScore() + 1L);
        user.setWeekScore(user.getWeekScore() + 1L);
        userRepository.save(user);

        return ApiResponse.success(SuccessMessage.PATCH_SCORE_SUCCESS, ScoreDto.buildScore(user));
    }

    public ApiResponse<ScoreDto> initDailyScore()
    {
        List<User> userList = userRepository.findAll();
        for (User user : userList)
        {
            user.setDayScore(0L);
            userRepository.save(user);
        }

        return ApiResponse.success(SuccessMessage.INIT_SCORE_SUCCESS);

    }

    public ApiResponse<ScoreDto> initWeeklyScore()
    {
        List<User> userList = userRepository.findAll();
        for (User user : userList)
        {
            user.setWeekScore(0L);
            userRepository.save(user);
        }

        return ApiResponse.success(SuccessMessage.INIT_SCORE_SUCCESS);

    }



}