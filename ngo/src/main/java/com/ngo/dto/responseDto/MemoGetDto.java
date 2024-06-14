package com.ngo.dto.responseDto;

import com.ngo.model.Memo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

/**
 * MemoGetDto is used to construct the response format of Api.
 * <pre>{@code
 * private final Long memoId;
 * private final String content;
 * }</pre>
 * @package : com.ngo.dto
 * @name : MemoGetDto.java
 * @date : 2024. 04. 24.
 * @author : siyunsmacbook
*/
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
