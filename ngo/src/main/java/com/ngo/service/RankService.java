package com.ngo.service;

import com.ngo.common.ApiResponse;
import com.ngo.common.exception.NotFoundException;
import com.ngo.common.message.ErrorMessage;
import com.ngo.common.message.SuccessMessage;
import com.ngo.dto.RankDto;
import com.ngo.dto.ScoreDto;
import com.ngo.dto.UserRankDto;
import com.ngo.model.User;
import com.ngo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RankService {
    private final UserRepository userRepository;

    public RankService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApiResponse<RankDto> getDailyRank(Long userId)
    {
        RankDto rankDto = new RankDto();

        userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.USER_NOT_FOUND));

        List<User> userList = userRepository.findAll().stream()
                .sorted(Comparator.comparing(User::getDayScore).reversed())
                .toList();

        long userRank = 0L;
        List<UserRankDto> userRankDtoList = new ArrayList<>();
        for (User user : userList)
        {
            userRank++;
            userRankDtoList.add(new UserRankDto(user.getUserId(), userRank, user.getUserName()));
            if (userId.equals(user.getUserId()))
            {
                rankDto.setUserId(userId);
                rankDto.setUserName(user.getUserName());
                rankDto.setUserRank(userRank);
            }
        }

        rankDto.setUserRankDtoList(userRankDtoList);
        return ApiResponse.success(SuccessMessage.GET_RANK_SUCCESS, rankDto);

    }

    public ApiResponse<RankDto> getWeeklyRank(Long userId)
    {
        RankDto rankDto = new RankDto();

        userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.USER_NOT_FOUND));

        List<User> userList = userRepository.findAll().stream()
                .sorted(Comparator.comparing(User::getWeekScore).reversed())
                .toList();

        long userRank = 0L;
        List<UserRankDto> userRankDtoList = new ArrayList<>();
        for (User user : userList)
        {
            userRank++;
            userRankDtoList.add(new UserRankDto(user.getUserId(), userRank, user.getUserName()));
            if (userId.equals(user.getUserId()))
            {
                rankDto.setUserId(userId);
                rankDto.setUserName(user.getUserName());
                rankDto.setUserRank(userRank);
            }
        }

        rankDto.setUserRankDtoList(userRankDtoList);
        return ApiResponse.success(SuccessMessage.GET_RANK_SUCCESS, rankDto);

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
