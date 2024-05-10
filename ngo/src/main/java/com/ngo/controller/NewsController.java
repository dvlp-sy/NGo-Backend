package com.ngo.controller;

import com.ngo.common.ApiResponse;
import com.ngo.model.TodayNews;
import com.ngo.service.NewsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NewsController
{
    private final NewsService newsService;

    public NewsController(NewsService newsService)
    {
        this.newsService = newsService;
    }

    @GetMapping("/today-news")
    ApiResponse<List<TodayNews>> getTodayNews(@RequestParam("level") String level)
    {
        return newsService.getTodayNews(level);
    }

    @PostMapping("/today-news")
    ApiResponse<Void> postTodayNews()
    {
        return newsService.postTodayNews();
    }
}
