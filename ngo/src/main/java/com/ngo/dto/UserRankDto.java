package com.ngo.dto;

import com.ngo.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRankDto
{
    private final Long userId;
    private final Long userRank;
    private final String userName;

}
