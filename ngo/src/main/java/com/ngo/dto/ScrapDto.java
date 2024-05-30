package com.ngo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

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