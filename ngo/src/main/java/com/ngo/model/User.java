package com.ngo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ngo.dto.RegisterDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * ==== User entity mapping class ====
 * @package : com.ngo.model
 * @name : User.java
 * @date : 2024. 04. 13.
 * @author : siyunsmacbook
*/

@Getter
@Setter
@Table
@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(nullable = false)
    private String loginPw;

    @Column(nullable = false)
    private String level;

    @Column
    private String profileImage;

    @Column
    private Long dayScore;

    @Column
    private Long weekScore;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Attendance> attendances = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Scrap> scraps = new HashSet<>();

    public User() {}

    @Builder(access = AccessLevel.PUBLIC)
    public User(String userName, String email, String loginId, String loginPw, String level, String profileImage, Long dayScore, Long weekScore)
    {
        this.userName = userName;
        this.email = email;
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.level = level;
        this.profileImage = profileImage;
        this.dayScore = dayScore;
        this.weekScore = weekScore;
    }

    public static User build(RegisterDto registerDto)
    {
        return User.builder()
                .userName(registerDto.getUserName())
                .email(registerDto.getEmail())
                .loginId(registerDto.getLoginId())
                .loginPw(registerDto.getLoginPw())
                .level(registerDto.getLevel())
                .profileImage(registerDto.getProfileImage())
                .dayScore(0L)
                .weekScore(0L)
                .build();
    }


}
