package com.ngo.dto;

import com.ngo.model.Scrap;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ScrapListDto
{
    private final Long userId;
    private final List<ScrapDto> scrapDtoList;

    @Builder(access = AccessLevel.PRIVATE)
    private ScrapListDto(Long userId, List<ScrapDto> scrapDtoList)
    {
        this.userId = userId;
        this.scrapDtoList = scrapDtoList;
    }

    public static ScrapListDto build(Long userId, List<ScrapDto> scrapDtoList)
    {
        return ScrapListDto.builder()
                .userId(userId)
                .scrapDtoList(scrapDtoList)
                .build();
    }

}
