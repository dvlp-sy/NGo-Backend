package com.ngo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Table
@Entity
public class Scrap
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scrap_id")
    private Long scrapId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String link;

    @Column
    private String media;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "scrap", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Memo> memos = new HashSet<>();

    @Autowired
    public Scrap() {}

    @Autowired
    @Builder(access = AccessLevel.PUBLIC)
    public Scrap(String title, String link, String media, User user)
    {
        this.title = title;
        this.link = link;
        this.media = media;
        this.user = user;
    }

}
