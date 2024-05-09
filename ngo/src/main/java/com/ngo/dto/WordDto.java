package com.ngo.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class WordDto
{
    private final String sup_no;
    private final String definition;
    private final String pos;

    @Builder(access = AccessLevel.PUBLIC)
    public WordDto(String sup_no, String definition, String pos)
    {
        this.sup_no = sup_no;
        this.definition = definition;
        this.pos = pos;
    }

}
