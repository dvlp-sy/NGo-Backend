package com.ngo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@Table
@Entity
public class Memo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memo_id")
    private Long memoId;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "scrap_id", nullable = false)
    @JsonBackReference
    private Scrap scrap;

    @Autowired
    public Memo() {}

    @Autowired
    @Builder(access = AccessLevel.PUBLIC)
    public Memo(String content, Scrap scrap)
    {
        this.content = content;
        this.scrap = scrap;
    }
}
