package com.ngo.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

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
