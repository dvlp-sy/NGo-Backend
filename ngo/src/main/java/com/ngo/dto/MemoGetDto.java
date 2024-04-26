package com.ngo.dto;

import com.ngo.model.Memo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemoGetDto
{
    private final Long memoId;
    private final String content;

    @Builder(access = AccessLevel.PRIVATE)
    private MemoGetDto(Long memoId, String content)
    {
        this.memoId = memoId;
        this.content = content;
    }

    public static MemoGetDto build(Memo memo)
    {
        return MemoGetDto.builder()
                .memoId(memo.getMemoId())
                .content(memo.getContent())
                .build();
    }

}
