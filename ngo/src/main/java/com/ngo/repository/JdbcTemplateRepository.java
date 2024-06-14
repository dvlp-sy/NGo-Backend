package com.ngo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public void initializeDatabase() {

        // 기존의 today_news 삭제
        jdbcTemplate.update("DELETE FROM today_news");

        // id 초기화
        for (int id = 16; id <= 30; id++) {
            jdbcTemplate.update("ALTER TABLE today_news AUTO_INCREMENT = 1");
        }

    }
}
