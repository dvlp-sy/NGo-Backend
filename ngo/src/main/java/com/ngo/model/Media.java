package com.ngo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * ==== Media entity mapping class====
 * @package : com.ngo.model
 * @name : Media.java
 * @date : 2024. 04. 13.
 * @author : siyunsmacbook
*/

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
