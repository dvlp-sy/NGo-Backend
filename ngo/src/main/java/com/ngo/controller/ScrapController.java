package com.ngo.controller;

import com.ngo.common.ApiResponse;
import com.ngo.dto.*;
import com.ngo.service.ScrapService;
import org.springframework.web.bind.annotation.*;

/**
 * ==== Scrap Controller for Retrieving Scrap Contents ====
 * @package : com.ngo.controller
 * @name : ScrapController.java
 * @date : 2024. 04. 20.
 * @author : siyunsmacbook
*/
@RestController
@RequestMapping("/api")
public class ScrapController
{
    private final ScrapService scrapService;

    public ScrapController(ScrapService scrapService) { this.scrapService = scrapService; }

    /**
     * 스크랩 관리
     */

    @GetMapping("/users/{userId}/scraps")
    public ApiResponse<ScrapListDto> getAllScraps(@PathVariable("userId") Long userId)
    {
        return scrapService.getAllScraps(userId);
    }

    @PostMapping("/users/{userId}/scraps")
    public ApiResponse<ScrapDto> postScrap(@PathVariable("userId") Long userId, @RequestBody ScrapDto scrapDto)
    {
        return scrapService.postScrap(userId, scrapDto);
    }

    @DeleteMapping("/users/{userId}/scraps/{scrapId}")
    public ApiResponse<ScrapDto> deleteScrap(@PathVariable("userId") Long userId, @PathVariable("scrapId") Long scrapId)
    {
        return scrapService.deleteScrap(userId, scrapId);
    }

    /**
     * 메모 관리
     */

    @GetMapping("/users/{userId}/scraps/{scrapId}/memos")
    public ApiResponse<MemoListDto> getAllMemos(@PathVariable("userId") Long userId, @PathVariable("scrapId") Long scrapId)
    {
        return scrapService.getAllMemos(userId, scrapId);
    }

    @PostMapping("/users/{userId}/scraps/{scrapId}/memos")
    public ApiResponse<MemoGetDto> postMemo(@PathVariable("userId") Long userId, @PathVariable("scrapId") Long scrapId, @RequestBody MemoDto memoDto)
    {
        return scrapService.postMemo(userId, scrapId, memoDto);
    }

    @DeleteMapping("/users/{userId}/scraps/{scrapId}/memos/{memoId}")
    public ApiResponse<MemoGetDto> deleteMemo(@PathVariable("userId") Long userId, @PathVariable("scrapId") Long scrapId, @PathVariable("memoId") Long memoId)
    {
        return scrapService.deleteMemo(userId, scrapId, memoId);
    }
}
