package com.ngo.dto.responseDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
/**
 * ScrapListDto is used to construct the response format of Api.
 * <pre>{@code
 *     private final Long userId;
 *     private final List<ScrapResponseDto> scrapDtoList;
 * }</pre>
 * @package : com.ngo.dto
 * @name : ScrapListDto.java
 * @date : 2024. 04. 24.
 * @author : siyunsmacbook
*/

@Getter
public class ScrapListDto
{
    private final Long userId;
    private final List<ScrapResponseDto> scrapDtoList;

    @Builder(access = AccessLevel.PRIVATE)
    private ScrapListDto(Long userId, List<ScrapResponseDto> scrapDtoList)
    {
        this.userId = userId;
        this.scrapDtoList = scrapDtoList;
    }

    public static ScrapListDto build(Long userId, List<ScrapResponseDto> scrapDtoList)
    {
        return ScrapListDto.builder()
                .userId(userId)
                .scrapDtoList(scrapDtoList)
                .build();
    }

}
