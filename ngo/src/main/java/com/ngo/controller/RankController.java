package com.ngo.controller;

import com.ngo.common.ApiResponse;
import com.ngo.dto.RankDto;
import com.ngo.dto.ScoreDto;
import com.ngo.service.RankService;
import org.springframework.web.bind.annotation.*;

/**
 * ==== Rank Controller to Fetch Ranking ====
 * @package : com.ngo.controller
 * @name : RankController.java
 * @date :2024. 04. 27.
 * @author : siyunsmacbook
*/

@RestController
@RequestMapping("/api")
public class RankController
{
    private final RankService rankService;

    public RankController(RankService rankService) { this.rankService = rankService; }

    @GetMapping("/users/{userId}/daily-ranks")
    public ApiResponse<RankDto> getDailyRank(@PathVariable("userId") Long userId)
    {
        return rankService.getDailyRank(userId);
    }

    @GetMapping("/users/{userId}/weekly-ranks")
    public ApiResponse<RankDto> getWeeklyRank(@PathVariable("userId") Long userId)
    {
        return rankService.getWeeklyRank(userId);
    }

    @PatchMapping("/users/{userId}/ranks")
    public ApiResponse<ScoreDto> patchScore(@PathVariable("userId") Long userId)
    {
        return rankService.patchScore(userId);
    }

    @PatchMapping("/daily-ranks")
    public ApiResponse<ScoreDto> initDailyScore()
    {
        return rankService.initDailyScore();
    }

    @PatchMapping("/weekly-ranks")
    public ApiResponse<ScoreDto> initWeeklyScore()
    {
        return rankService.initWeeklyScore();
    }

}
