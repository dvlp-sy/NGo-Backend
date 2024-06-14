package com.ngo.service;

import com.ngo.common.ApiResponse;
import com.ngo.common.exception.UnauthorizedException;
import com.ngo.common.message.ErrorMessage;
import com.ngo.common.message.SuccessMessage;
import com.ngo.dto.requestDto.LoginFormDto;
import com.ngo.dto.responseDto.UserDto;
import com.ngo.model.User;
import com.ngo.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

/**
 * LoginService class offers login and logout features.
 * <pre>{@code
 * public ApiResponse<Void> loginUser(LoginFormDto loginFormDto, HttpServletRequest request, HttpServletResponse response);
 * public ApiResponse<Void> logoutUser(HttpServletRequest request, HttpServletResponse response);
 * }</pre>
 * @package : com.ngo.service
 * @name : LoginService.java
 * @date : 2024. 05. 09.
 * @author : siyunsmacbook
*/

@Service
public class LoginService
{
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    /**
     * 로그인
     */

    public ApiResponse<UserDto> loginUser(LoginFormDto loginFormDto, HttpServletRequest request, HttpServletResponse response)
    {
        User user = userRepository.findByLoginId(loginFormDto.getLoginId())
                .filter(u -> u.getLoginPw().equals(loginFormDto.getLoginPw()))
                .orElseThrow(() -> new UnauthorizedException(ErrorMessage.PASSWORD_NOT_MATCH));

        HttpSession session = request.getSession();
        session.setAttribute("loginUser", user);

        Cookie cookie = new Cookie("userId", user.getLoginId());
        cookie.setPath("/");
        cookie.setMaxAge(100);
        response.addCookie(cookie);

        return ApiResponse.success(SuccessMessage.LOGIN_SUCCESS, UserDto.build(user));
    }

    /**
     * 로그아웃
     */

    public ApiResponse<Void> logoutUser(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession(false);
        if (session != null)
            session.invalidate();

        Cookie cookie = new Cookie("userId", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return ApiResponse.success(SuccessMessage.LOGOUT_SUCCESS);
    }
}
