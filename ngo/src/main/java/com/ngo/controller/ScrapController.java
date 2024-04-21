package com.ngo.controller;

import com.ngo.common.ApiResponse;
import com.ngo.dto.ScrapDto;
import com.ngo.service.ScrapService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScrapController
{
    private final ScrapService scrapService;

    public ScrapController(ScrapService scrapService) { this.scrapService = scrapService; }

    @PostMapping("/user/{userId}/scrap")
    public ApiResponse<ScrapDto> postScrap(@PathVariable("userId") Long userId, @RequestBody ScrapDto scrapDto)
    {
        return scrapService.postScrap(userId, scrapDto);
    }

    @DeleteMapping("/user/{userId}/scrap/{scrapId}")
    public ApiResponse<ScrapDto> deleteScrap(@PathVariable("userId") Long userId, @PathVariable("scrapId") Long scrapId)
    {
        return scrapService.deleteScrap(userId, scrapId);
    }

}
