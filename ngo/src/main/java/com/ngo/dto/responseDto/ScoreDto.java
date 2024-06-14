package com.ngo.dto.responseDto;

import com.ngo.model.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

/**
 * ScoreDto is used to construct the response format of Api.
 * <pre>{@code
 *     private final Long userId;
 *     private final String userName;
 *     private final Long dailyScore;
 *     private final Long weeklyScore;
 * }</pre>
 * @package : com.ngo.dto
 * @name : ScoreDto.java
 * @date : 2024. 04. 27.
 * @author : siyunsmacbook
*/
@Getter
public class ScoreDto {
    private final Long userId;
    private final String userName;
    private final Long dailyScore;
    private final Long weeklyScore;

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
