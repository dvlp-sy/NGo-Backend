package com.ngo.controller;

import com.ngo.common.ApiResponse;
import com.ngo.dto.RankDto;
import com.ngo.dto.ScoreDto;
import com.ngo.service.RankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankController
{
    private final RankService rankService;

    public RankController(RankService rankService) { this.rankService = rankService; }

    @GetMapping("/user/{userId}/daily-rank")
    public ApiResponse<RankDto> getDailyRank(@PathVariable("userId") Long userId)
    {
        return rankService.getDailyRank(userId);
    }

    @GetMapping("/user/{userId}/weekly-rank")
    public ApiResponse<RankDto> getWeeklyRank(@PathVariable("userId") Long userId)
    {
        return rankService.getWeeklyRank(userId);
    }

    @PatchMapping("/user/{userId}/rank")
    public ApiResponse<ScoreDto> patchScore(@PathVariable("userId") Long userId)
    {
        return rankService.patchScore(userId);
    }

    @PatchMapping("/daily-rank")
    public ApiResponse<ScoreDto> initDailyScore()
    {
        return rankService.initDailyScore();
    }

    @PatchMapping("/weekly-rank")
    public ApiResponse<ScoreDto> initWeeklyScore()
    {
        return rankService.initWeeklyScore();
    }

}
