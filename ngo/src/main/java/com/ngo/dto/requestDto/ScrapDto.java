package com.ngo.dto.requestDto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * ScrapDto is used to construct the request body and response format of Api.
 * <pre>{@code
 *     private String title;
 *     private String link;
 *     private String media;
 * }</pre>
 * @package : com.ngo.dto
 * @name : ScrapDto.java
 * @date : 2024. 04. 20.
 * @author : siyunsmacbook
*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScrapDto {
    private String title;
    private String link;
    private String media;
    private String mediaCode;
    private String articleCode;
}