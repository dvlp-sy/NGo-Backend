package com.ngo.dto;

import com.ngo.model.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ScoreDto {
    Long userId;
    String userName;
    Long dailyScore;
    Long weeklyScore;

    @Builder(access = AccessLevel.PRIVATE)
    private ScoreDto(Long userId, String userName, Long dailyScore, Long weeklyScore) {
        this.userId = userId;
        this.userName = userName;
        this.dailyScore = dailyScore;
        this.weeklyScore = weeklyScore;
    }

    public static ScoreDto buildScore(User user) {
        return ScoreDto.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .dailyScore(user.getDayScore())
                .weeklyScore(user.getWeekScore())
                .build();
    }

}
