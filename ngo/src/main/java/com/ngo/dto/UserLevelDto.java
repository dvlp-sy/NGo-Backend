package com.ngo.dto;

import lombok.*;

/**
 * UserLevelDto is used to construct the request body and response format of Api.
 * <pre>{@code
 *     private String level;
 * }</pre>
 * @package : com.ngo.dto
 * @name : UserLevelDto.java
 * @date : 2024. 04. 19.
 * @author : siyunsmacbook
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLevelDto
{
    private String level;
}
