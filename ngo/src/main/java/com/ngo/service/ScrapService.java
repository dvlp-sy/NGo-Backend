package com.ngo.service;

import com.ngo.common.ApiResponse;
import com.ngo.common.exception.NotFoundException;
import com.ngo.common.message.ErrorMessage;
import com.ngo.common.message.SuccessMessage;
import com.ngo.dto.ScrapDto;
import com.ngo.model.Scrap;
import com.ngo.model.User;
import com.ngo.repository.ScrapRepository;
import com.ngo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ScrapService
{
    private final ScrapRepository scrapRepository;
    private final UserRepository userRepository;

    public ScrapService(ScrapRepository scrapRepository, UserRepository userRepository)
    {
        this.scrapRepository = scrapRepository;
        this.userRepository = userRepository;
    }

    /**
     * 스크랩 관리
     */

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

    /**
     * 메모 관리
     */
}
