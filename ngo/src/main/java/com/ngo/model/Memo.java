package com.ngo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}
