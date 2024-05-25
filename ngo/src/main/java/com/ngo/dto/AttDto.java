package com.ngo.dto;

import com.ngo.model.Attendance;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

/**
 * AttDto is used to construct the response format of Api.
 * <pre>{@code
 * private final Long attendanceId;
 * private final LocalDate date;
 * }</pre>
 * @package : com.ngo.dto
 * @name : AttDto.java
 * @date : 2024. 04. 17.
 * @author : siyunsmacbook
*/

@Getter
public class AttDto
{
    private final Long attendanceId;
    private final LocalDate date;

    @Builder(access = AccessLevel.PRIVATE)
    private AttDto(Long attendanceId, LocalDate date)
    {
        this.attendanceId = attendanceId;
        this.date = date;
    }

    public static AttDto build(Attendance attendance)
    {
        return AttDto.builder()
                .attendanceId(attendance.getAttendanceId())
                .date(attendance.getDate())
                .build();
    }
}
