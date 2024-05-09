package com.ngo.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class WordListDto
{
    private final String searchWord;
    private final List<WordDto> wordList;

    public WordListDto(String word, List<WordDto> wordDtoList)
    {
        this.searchWord = word;
        this.wordList = wordDtoList;
    }
}
