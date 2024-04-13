package com.ngo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table
@Entity
public class Text
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long textId;

    @Column
    private String sentence;

    @ManyToOne
    @JoinColumn(name = "news_id", nullable = false)
    @JsonBackReference
    private TodayNews todayNews;
}
