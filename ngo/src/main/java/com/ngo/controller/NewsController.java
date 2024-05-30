package com.ngo.controller;

import com.ngo.common.ApiResponse;
import com.ngo.model.Media;
import com.ngo.model.TodayNews;
import com.ngo.service.NewsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * ==== News Controller for Retrieving TodayNews and MediaNews ====
 * @package : com.ngo.controller
 * @name : NewsController.java
 * @date : 2024. 05. 10.
 * @author : siyunsmacbook
*/
@RestController
@RequestMapping("/api")
public class NewsController
{
    private final NewsService newsService;

    public NewsController(NewsService newsService)
    {
        this.newsService = newsService;
    }

    /**
     * 오늘의 신문
     */
    @GetMapping("/today-news")
    public ApiResponse<List<TodayNews>> getTodayNews(@RequestParam("level") String level)
    {
        return newsService.getTodayNews(level);
    }

    @PostMapping("/today-news")
    public ApiResponse<Void> postTodayNews()
    {
        return newsService.postTodayNews();
    }

    /**
     * 언론사별 신문
     */
    @GetMapping("/media")
    public ApiResponse<Map<String, List<Media>>> getAllMedia()
    {
        return newsService.getAllMedia();
    }

    @GetMapping("/media/{mediaId}")
    public ApiResponse<Map> getAllMediaNews(@PathVariable("mediaId") String mediaId)
    {
        return newsService.getAllMediaNews(mediaId);
    }

}
