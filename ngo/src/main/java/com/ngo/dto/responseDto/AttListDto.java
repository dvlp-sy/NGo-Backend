package com.ngo.dto.responseDto;

import lombok.Getter;

import java.util.List;

/**
 * AttListDto is used to construct the response format of Api.
 * <pre>{@code
 * private final Long userId;
 * private final List<AttDto> attendanceList;
 * }</pre>
 * @package : com.ngo.dto
 * @name : AttListDto.java
 * @date : 2024. 04. 17.
 * @author : siyunsmacbook
*/
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
