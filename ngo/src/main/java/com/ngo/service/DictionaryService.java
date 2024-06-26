package com.ngo.service;

import com.ngo.common.ApiResponse;
import com.ngo.common.message.SuccessMessage;
import com.ngo.dto.responseDto.WordDto;
import com.ngo.dto.responseDto.WordListDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * DictionaryService class offers dictionary search features.
 * <pre>{@code
 * public ApiResponse<WordListDto> getWords(String word);
 * }</pre>
 * @package : com.ngo.service
 * @name : DictionaryService.java
 * @date : 2024. 05. 09.
 * @author : siyunsmacbook
*/

@Service
public class DictionaryService
{
    private final WebClient webClient;

    @Value(value = "${spring.dict.key}")
    private String authKey;

    public DictionaryService()
    {
        ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(100 * 1024 * 1024))
                .build();
        this.webClient = WebClient.builder().exchangeStrategies(strategies).build();
    }

    public ApiResponse<WordListDto> getWords(String word)
    {
        Map wordData;
        try {
            wordData = webClient.get()
                    .uri("http://13.124.142.65:8000/getWords/"+word)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();
        } catch(Exception e) {
            throw new IllegalStateException("검색 결과를 불러오는 과정에서 오류가 발생했습니다");
        }

        WordListDto wordListDto = createWordListDto(word, wordData);
        return ApiResponse.success(SuccessMessage.GET_WORDS_SUCCESS, wordListDto);

    }

    private WordListDto createWordListDto(String word, Map wordData)
    {
        List<WordDto> wordDtoList = new ArrayList<>();
        if (wordData != null && !wordData.isEmpty())
        {
            String searchWord = wordData.get("searchWord").toString();
            List<Map<String, String>> wordList = (List<Map<String, String>>) wordData.get("wordList");

            for (Map<String, String> wordMap : wordList)
            {
                wordDtoList.add(WordDto.builder()
                        .sup_no(wordMap.get("sup_no"))
                        .definition(wordMap.get("definition"))
                        .pos(wordMap.get("pos"))
                        .build());
            }
        }

        return new WordListDto(word, wordDtoList);
    }

}
