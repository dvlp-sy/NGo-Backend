package com.ngo.controller;

import com.ngo.common.ApiResponse;
import com.ngo.service.NewsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NewsController
{
    private final NewsService newsService;

    public NewsController(NewsService newsService)
    {
        this.newsService = newsService;
    }

    @PostMapping("/today-news")
    ApiResponse<Void> postTodayNews()
    {
        return newsService.postTodayNews();
    }
}
