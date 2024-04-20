package com.ngo.dto;

import com.ngo.model.Attendance;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class AttListDto
{
    private final Long userId;
    private final List<AttDto> attendanceList;

    public AttListDto(Long userId, List<AttDto> attDtoList)
    {
        this.userId = userId;
        this.attendanceList = attDtoList;
    }

}
