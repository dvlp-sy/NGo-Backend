package com.ngo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * LoginFormDto is used to construct the request body and response format of Api.
 * <pre>{@code
 * private final String loginId;
 * private final String loginPw;
 * }</pre>
 * @package : com.ngo.dto
 * @name : LoginFormDto.java
 * @date : 2024. 05. 09.
 * @author : siyunsmacbook
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginFormDto
{
    private String loginId;
    private String loginPw;
}
