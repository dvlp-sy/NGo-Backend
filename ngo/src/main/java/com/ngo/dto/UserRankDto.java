package com.ngo.dto;

import com.ngo.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * UserRankDto is used to construct the response format of Api.
 * <pre>{@code
 *     private final Long userId;
 *     private final Long userRank;
 *     private final String userName;
 * }</pre>
 * @package : com.ngo.dto
 * @name : UserRankDto.java
 * @date : 2024. 04. 28.
 * @author : siyunsmacbook
*/
@Getter
@AllArgsConstructor
public class UserRankDto
{
    private final Long userId;
    private final Long userRank;
    private final String userName;

}
