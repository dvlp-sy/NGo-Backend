package com.ngo.service;

import com.ngo.common.ApiResponse;
import com.ngo.common.message.SuccessMessage;
import com.ngo.model.Media;
import com.ngo.model.TodayNews;
import com.ngo.repository.MediaRepository;
import com.ngo.repository.TodayNewsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * NewsService class offers TodayNews and MediaNews features.
 * <pre>{@code
 * // getTodayNews
 * public ApiResponse<List<TodayNews>> getTodayNews(String level);
 * // postTodayNews
 * public ApiResponse<Void> postTodayNews();
 * // getAllMedia
 * public ApiResponse<Map<String, List<Media>>> getAllMedia();
 * // getAllMediaNews
 * public ApiResponse<Map> getAllMediaNews(String mediaId);
 * }</pre>
 * @package : com.ngo.service
 * @name : NewsService.java
 * @date : 2024. 05. 10.
 * @author : siyunsmacbook
*/
@Service
public class NewsService
{
    private final TodayNewsRepository todayNewsRepository;
    private final MediaRepository mediaRepository;
    private final WebClient webClient;

    public NewsService(TodayNewsRepository todayNewsRepository, MediaRepository mediaRepository)
    {
        ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(100 * 1024 * 1024))
                .build();
        this.webClient = WebClient.builder().exchangeStrategies(strategies).build();
        this.todayNewsRepository = todayNewsRepository;
        this.mediaRepository = mediaRepository;

    }

    /**
     * 오늘의 신문
     */

    public ApiResponse<List<TodayNews>> getTodayNews(String level)
    {
        List<TodayNews> todayNewsList = todayNewsRepository.findAllByLevel(level);
        return ApiResponse.success(SuccessMessage.GET_TODAY_NEWS_SUCCESS, todayNewsList);
    }

    public ApiResponse<Void> postTodayNews()
    {
        Map todayNewsData;
        try {
            todayNewsData = webClient.get()
                    .uri("http://localhost:8003/selectNews")
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();
        } catch(Exception e) {
            throw new IllegalStateException("뉴스 생성 과정에서 오류가 발생했습니다");
        }

        saveTodayNews(todayNewsData);
        return ApiResponse.success(SuccessMessage.POST_TODAY_NEWS_SUCCESS);
    }

    private void saveTodayNews(Map<String, List> todayNewsData)
    {
        if (todayNewsData != null && !todayNewsData.isEmpty())
        {
            for (String key : todayNewsData.keySet())
            {
                List<Map<String, String>> highLevelNews = (List<Map<String, String>>) todayNewsData.get(key);
                for (Map<String, String> newsMap : highLevelNews)
                {
                    TodayNews todayNews = TodayNews.builder()
                            .title(newsMap.get("title"))
                            .media(newsMap.get("media"))
                            .editor(newsMap.get("editor"))
                            .thumbnail(newsMap.get("thumbnail"))
                            .summary(newsMap.get("summary"))
                            .contents(newsMap.get("contents"))
                            .level(key)
                            .build();

                    todayNewsRepository.save(todayNews);
                }
            }
        }
    }

    /**
     * 언론사별 신문
     */

    public ApiResponse<Map<String, List<Media>>> getAllMedia()
    {
        List<Media> mediaList = mediaRepository.findAll();
        Map<String, List<Media>> mediaMap = new HashMap<>();
        mediaMap.put("mediaList", mediaList);
        return ApiResponse.success(SuccessMessage.GET_MEDIA_SUCCESS, mediaMap);
    }

    public ApiResponse<Map> getAllMediaNews(String mediaId)
    {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateStr = dateFormat.format(date);

        String url = "http://localhost:8004/getMediaNews?oid="+mediaId+"&date="+dateStr;
        Map newsData;
        try {
            newsData = webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();
        } catch(Exception e) {
            throw new IllegalStateException("뉴스를 불러오는 과정에서 오류가 발생했습니다");
        }

        return ApiResponse.success(SuccessMessage.GET_MEDIA_NEWS_SUCCESS, newsData);
    }
}
