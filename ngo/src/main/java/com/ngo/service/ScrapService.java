package com.ngo.service;

import com.ngo.common.ApiResponse;
import com.ngo.common.exception.NotFoundException;
import com.ngo.common.message.ErrorMessage;
import com.ngo.common.message.SuccessMessage;
import com.ngo.dto.MemoDto;
import com.ngo.dto.MemoGetDto;
import com.ngo.dto.ScrapDto;
import com.ngo.dto.ScrapListDto;
import com.ngo.model.Memo;
import com.ngo.model.Scrap;
import com.ngo.model.User;
import com.ngo.repository.MemoRepository;
import com.ngo.repository.ScrapRepository;
import com.ngo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScrapService
{
    private final ScrapRepository scrapRepository;
    private final UserRepository userRepository;
    private final MemoRepository memoRepository;

    public ScrapService(ScrapRepository scrapRepository, UserRepository userRepository, MemoRepository memoRepository)
    {
        this.scrapRepository = scrapRepository;
        this.userRepository = userRepository;
        this.memoRepository = memoRepository;
    }

    /**
     * 스크랩 관리
     */

    public ApiResponse<ScrapListDto> getAllScraps(Long userId)
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.USER_NOT_FOUND));

        List<ScrapDto> scrapListDto = scrapRepository.findByUser_UserId(userId).stream()
                .map(scrap -> {
                    return new ScrapDto(scrap.getTitle(), scrap.getLink(), scrap.getMedia());
                })
                .toList();

        return ApiResponse.success(SuccessMessage.GET_SCRAP_SUCCESS, ScrapListDto.build(userId, scrapListDto));
    }

    public ApiResponse<ScrapDto> postScrap(Long userId, ScrapDto scrapDto)
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.USER_NOT_FOUND));

        Scrap scrap = Scrap.builder()
                .title(scrapDto.getTitle())
                .link(scrapDto.getLink())
                .media(scrapDto.getMedia())
                .user(user)
                .build();

        scrapRepository.save(scrap);
        return ApiResponse.success(SuccessMessage.POST_SCRAP_SUCCESS, scrapDto);
    }

    public ApiResponse<ScrapDto> deleteScrap(Long userId, Long scrapId)
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.USER_NOT_FOUND));

        Scrap scrap = scrapRepository.findById(scrapId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.SCRAP_NOT_FOUND));

        scrapRepository.delete(scrap);
        return ApiResponse.success(SuccessMessage.DELETE_SCRAP_SUCCESS);
    }

    /**
     * 메모 관리
     */

    public ApiResponse<MemoGetDto> postMemo(Long userId, Long scrapId, MemoDto memoDto)
    {
        userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.USER_NOT_FOUND));

        Scrap scrap = scrapRepository.findById(scrapId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.SCRAP_NOT_FOUND));

        if (!userId.equals(scrap.getUser().getUserId()))
            throw new NotFoundException(ErrorMessage.SCRAP_NOT_FOUND);

        Memo memo = Memo.builder()
                .content(memoDto.getContent())
                .scrap(scrap)
                .build();

        memoRepository.save(memo);
        return ApiResponse.success(SuccessMessage.POST_MEMO_SUCESS, MemoGetDto.build(memo));
    }

}
