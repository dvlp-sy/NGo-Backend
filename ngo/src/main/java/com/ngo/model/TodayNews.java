package com.ngo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    private Date date;

    @Column(nullable = false)
    private String title;

    @Column
    private String media;

    @Column
    private String editor;

    @OneToMany(mappedBy = "todayNews", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Text> texts = new HashSet<>();

}
