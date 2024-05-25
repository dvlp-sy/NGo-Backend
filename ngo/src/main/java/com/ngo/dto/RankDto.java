package com.ngo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * RankDto is used to construct the response format of Api.
 * <pre>{@code
 *     private Long userId;
 *     private String userName;
 *     private Long userRank;
 *     private List<UserRankDto> userRankDtoList;
 * }</pre>
 * @package : com.ngo.dto
 * @name : RankDto.java
 * @date : 2024. 04. 28.
 * @author : siyunsmacbook
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RankDto
{
    private Long userId;
    private String userName;
    private Long userRank;
    private List<UserRankDto> userRankDtoList;
}
