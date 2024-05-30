package com.ngo.repository;

import com.ngo.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;

/**
 * ==== AttendanceRepository Interface ====
 * @package : com.ngo.repository
 * @name : AttendanceRepository.java
 * @date : 2024. 04. 17.
 * @author : siyunsmacbook
*/

@RepositoryRestResource
public interface AttendanceRepository extends JpaRepository<Attendance, Long>
{
    List<Attendance> findByUser_UserId(Long userId);
    Attendance findByDate(Date date);
}
