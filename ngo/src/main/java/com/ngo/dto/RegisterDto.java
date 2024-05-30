package com.ngo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * RegisterDto is used to construct the request body of Api.
 * <pre>{@code
 *     private String loginId;
 *     private String email;
 *     private String loginPw;
 *     private String userName;
 *     private String profileImage;
 *     private String level;
 * }</pre>
 * @package : com.ngo.dto
 * @name : RegisterDto.java
 * @date : 2024. 05. 08.
 * @author : siyunsmacbook
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto
{
    private String loginId;
    private String email;
    private String loginPw;
    private String userName;
    private String profileImage;
    private String level;
}
