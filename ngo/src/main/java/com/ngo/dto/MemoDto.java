package com.ngo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * MemoDto is used to construct the request body and response format of Api.
 * <pre>{@code
 * private String content;
 * }</pre>
 * @package : com.ngo.dto
 * @name : MemoDto.java
 * @date : 2024. 04. 24.
 * @author : siyunsmacbook
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemoDto
{
    private String content;
}
