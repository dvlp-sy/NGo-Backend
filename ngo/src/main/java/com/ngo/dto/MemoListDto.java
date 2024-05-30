package com.ngo.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * MemoListDto is used to construct the response format of Api.
 * <pre>{@code
 * private final Long scrapId;
 * private final List<MemoGetDto> memoList;
 * }</pre>
 * @package : com.ngo.dto
 * @name : MemoListDto.java
 * @date : 2024. 04. 26.
 * @author : siyunsmacbook
*/

@Getter
public class MemoListDto
{
    private final Long scrapId;
    private final List<MemoGetDto> memoList;

    @Builder(access = AccessLevel.PUBLIC)
    public MemoListDto(Long scrapId, List<MemoGetDto> memoList)
    {
        this.scrapId = scrapId;
        this.memoList = memoList;
    }
}
