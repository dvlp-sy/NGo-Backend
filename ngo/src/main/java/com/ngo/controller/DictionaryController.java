package com.ngo.controller;

import com.ngo.common.ApiResponse;
import com.ngo.dto.responseDto.WordListDto;
import com.ngo.service.DictionaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ==== Dictionary Controller for Retrieving Dictionary Search Results ====
 * @package : com.ngo.controller
 * @name : DictionaryController.java
 * @date : 2024. 05. 09.
 * @author : siyunsmacbook
*/

@RestController
@RequestMapping("/api")
public class DictionaryController
{
    private final DictionaryService dictionaryService;

    public DictionaryController(DictionaryService dictionaryService)
    {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping("/dict")
    public ApiResponse<WordListDto> getWords(@RequestParam(name = "search") String word)
    {
        return dictionaryService.getWords(word);
    }
}
