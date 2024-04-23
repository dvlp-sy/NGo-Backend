package com.ngo.common.message;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessMessage
{
    /**
     * Login
     */

    /**
     * User
     */
    GET_USER_SUCCESS(OK, "유저 정보 불러오기에 성공했습니다"),
    GET_USER_ATTENDANCE_SUCCESS(OK, "출석 정보 불러오기에 성공했습니다"),
    POST_USER_ATTENDANCE_SUCCESS(CREATED, "출석 정보 업데이트에 성공했습니다"),
    PATCH_USER_LEVEL_SUCCESS(OK, "레벨 정보 업데이트에 성공했습니다"),

    /**
     * News
     */

    /**
     * Scrap
     */
    GET_SCRAP_SUCCESS(OK, "스크랩 불러오기에 성공했습니다"),
    POST_SCRAP_SUCCESS(CREATED, "스크랩 업로드에 성공했습니다"),
    DELETE_SCRAP_SUCCESS(NO_CONTENT, "스크랩 삭제에 성공했습니다")

    /**
     * Dictionary
     */

    /**
     * Rank
     */

    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode()
    {
        return httpStatus.value();
    }
}
