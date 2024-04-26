package com.ngo.dto;

import com.ngo.model.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ScoreDto
{
    Long userId;
    String userName;
    Long score;

    @Builder(access = AccessLevel.PRIVATE)
    private ScoreDto(Long userId, String userName, Long score)
    {
        this.userId = userId;
        this.userName = userName;
        this.score = score;
    }

    public static ScoreDto buildDailyScore(User user)
    {
        return ScoreDto.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .score(user.getDayScore())
                .build();
    }

}
