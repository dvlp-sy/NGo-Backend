package com.ngo.dto.responseDto;

import lombok.Getter;

import java.util.List;

/**
 * WordListDto is used to construct the response format of Api.
 * <pre>{@code
 *     private final String searchWord;
 *     private final List<WordDto> wordList;
 * }</pre>
 * @package : com.ngo.dto
 * @name : WordListDto.java
 * @date : 2024. 05. 09.
 * @author : siyunsmacbook
*/
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
