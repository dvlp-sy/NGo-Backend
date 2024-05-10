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
    LOGIN_SUCCESS(CREATED, "로그인에 성공했습니다"),
    LOGOUT_SUCCESS(CREATED, "로그아웃에 성공했습니다"),

    /**
     * User
     */
    REGISTER_USER_SUCCESS(CREATED, "회원가입에 성공했습니다"),
    WITHDRAWAL_USER_SUCCESS(NO_CONTENT, "회원탈퇴에 성공했습니다"),
    GET_USER_SUCCESS(OK, "유저 정보 불러오기에 성공했습니다"),
    GET_USER_ATTENDANCE_SUCCESS(OK, "출석 정보 불러오기에 성공했습니다"),
    POST_USER_ATTENDANCE_SUCCESS(CREATED, "출석 정보 업데이트에 성공했습니다"),
    PATCH_USER_LEVEL_SUCCESS(OK, "레벨 정보 업데이트에 성공했습니다"),
    PATCH_USER_PW_SUCCESS(OK, "비밀번호 변경에 성공했습니다"),

    /**
     * News
     */
    POST_TODAY_NEWS_SUCCESS(CREATED, "오늘의 뉴스 생성에 성공했습니다"),
    GET_TODAY_NEWS_SUCCESS(OK, "오늘의 뉴스 불러오기에 성공했습니다"),
    GET_MEDIA_SUCCESS(OK, "언론사 불러오기에 성공했습니다"),
    GET_MEDIA_NEWS_SUCCESS(OK, "언론사별 뉴스 불러오기에 성공했습니다"),

    /**
     * Scrap
     */
    GET_SCRAP_SUCCESS(OK, "스크랩 불러오기에 성공했습니다"),
    POST_SCRAP_SUCCESS(CREATED, "스크랩 업로드에 성공했습니다"),
    DELETE_SCRAP_SUCCESS(NO_CONTENT, "스크랩 삭제에 성공했습니다"),
    GET_MEMO_SUCCESS(OK, "메모 불러오기에 성공했습니다"),
    POST_MEMO_SUCESS(CREATED, "메모 업로드에 성공했습니다"),
    DELETE_MEMO_SUCCESS(NO_CONTENT, "메모 삭제에 성공했습니다"),

    /**
     * Dictionary
     */
    GET_WORDS_SUCCESS(OK, "사전 불러오기에 성공했습니다"),

    /**
     * Rank
     */
    GET_RANK_SUCCESS(OK, "랭킹 불러오기에 성공했습니다"),
    PATCH_SCORE_SUCCESS(OK, "스코어 업데이트에 성공했습니다"),
    INIT_SCORE_SUCCESS(OK, "스코어 초기화에 성공했습니다")

    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode()
    {
        return httpStatus.value();
    }
}
