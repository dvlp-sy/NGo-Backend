package com.ngo.dto;

import com.ngo.model.Attendance;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class AttDto
{
    private final Long attendanceId;
    private final Date date;

    @Builder(access = AccessLevel.PRIVATE)
    private AttDto(Long attendanceId, Date date)
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
