package com.ngo.dto;

import com.ngo.model.Scrap;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ScrapGetDto
{
    private final Long scrapId;
    private final String title;
    private final String link;
    private final String media;

    @Builder(access = AccessLevel.PRIVATE)
    private ScrapGetDto(Long scrapId, String title, String link, String media)
    {
        this.scrapId = scrapId;
        this.title = title;
        this.link = link;
        this.media = media;
    }

    public static ScrapGetDto build(Scrap scrap)
    {
        return ScrapGetDto.builder()
                .scrapId(scrap.getScrapId())
                .title(scrap.getTitle())
                .link(scrap.getLink())
                .media(scrap.getMedia())
                .build();
    }

}
