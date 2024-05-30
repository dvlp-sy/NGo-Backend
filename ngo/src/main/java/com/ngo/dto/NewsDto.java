package com.ngo.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

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
