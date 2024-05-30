package com.ngo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

/**
 * ==== ====
 * @package : com.ngo.model
 * @name : Attendance.java
 * @date : 2024. 04. 13.
 * @author : siyunsmacbook
*/

@Getter
@Setter
@Table
@Entity
public class Attendance
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long attendanceId;

    @Column(nullable = false)
    @CreatedDate
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    public Attendance() {}

    public Attendance(LocalDate date, User user)
    {
        this.date = date;
        this.user = user;
    }

}
