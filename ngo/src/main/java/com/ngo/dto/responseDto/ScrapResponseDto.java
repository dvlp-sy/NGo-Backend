package com.ngo.dto.responseDto;

import com.ngo.model.Scrap;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ScrapResponseDto {
    private final Long scrapId;
    private final String title;
    private final String media;

    @Builder(access = AccessLevel.PRIVATE)
    private ScrapResponseDto(Long scrapId, String title, String media) {
        this.scrapId = scrapId;
        this.title = title;
        this.media = media;
    }

    public static ScrapResponseDto build(Scrap scrap) {
        return ScrapResponseDto.builder()
                .scrapId(scrap.getScrapId())
                .title(scrap.getTitle())
                .media(scrap.getMedia())
                .build();
    }
}
