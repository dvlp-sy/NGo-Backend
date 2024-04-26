package com.ngo.controller;

import com.ngo.common.ApiResponse;
import com.ngo.dto.ScoreDto;
import com.ngo.service.RankService;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankController
{
    private final RankService rankService;

    public RankController(RankService rankService) { this.rankService = rankService; }

    @PatchMapping("/user/{userId}/daily-rank")
    public ApiResponse<ScoreDto> patchDailyScore(@PathVariable("userId") Long userId)
    {
        return rankService.patchDailyScore(userId);
    }
}
