package com.ngo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * ==== TodayNews entity mapping class ====
 * @package : com.ngo.model
 * @name : TodayNews.java
 * @date : 2024. 04. 13.
 * @author : siyunsmacbook
*/

@Getter
@Setter
@Table
@Entity
public class TodayNews
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private Long newsId;

    @Column
    @CreatedDate
    private LocalDate date;

    @Column(nullable = false)
    private String title;

    @Column
    private String media;

    @Column
    private String editor;

    @Column
    private String thumbnail;

    @Column
    private String summary;

    @Column(length = 10000)
    private String contents;

    @Column
    private String level;

    @Column
    private String mediaCode;

    @Column
    private String articleCode;

    public TodayNews() {}

    @Builder(access = AccessLevel.PUBLIC)
    public TodayNews(String title, String media, String editor, String thumbnail, String summary, String contents, String level, String mediaCode, String articleCode)
    {
        this.title = title;
        this.media = media;
        this.editor = editor;
        this.thumbnail = thumbnail;
        this.summary = summary;
        this.contents = contents;
        this.level = level;
        this.mediaCode = mediaCode;
        this.articleCode = articleCode;
    }

}
