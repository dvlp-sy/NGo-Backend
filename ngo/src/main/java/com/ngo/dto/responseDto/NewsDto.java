package com.ngo.dto.responseDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

/**
 * NewsDto is used to construct the response format of Api.
 * <pre>{@code
 *     private final String title;
 *     private final String contents;
 *     private final String editor;
 *     private final String media;
 *     private final String summary;
 *     private final String thumbnail;
 * }</pre>
 * @package : com.ngo.dto
 * @name : NewsDto.java
 * @date : 2024. 05. 30.
 * @author : siyunsmacbook
*/
@Getter
public class NewsDto {
    private final String title;
    private final String contents;
    private final String editor;
    private final String media;
    private final String summary;
    private final String thumbnail;

    @Builder(access = AccessLevel.PUBLIC)
    public NewsDto(String title, String contents, String editor, String media, String summary, String thumbnail) {
        this.title = title;
        this.contents = contents;
        this.editor = editor;
        this.media = media;
        this.summary = summary;
        this.thumbnail = thumbnail;
    }

}
