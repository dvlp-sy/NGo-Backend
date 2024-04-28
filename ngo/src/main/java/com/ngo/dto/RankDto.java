package com.ngo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
