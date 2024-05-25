package com.ngo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table
@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long media_id;

    @Column(nullable = false)
    private String oid;

    @Column(nullable = false)
    private String name;

    @Column
    private String image;
}
