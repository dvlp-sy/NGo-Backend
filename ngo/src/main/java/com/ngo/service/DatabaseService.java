package com.ngo.service;

import com.ngo.repository.JdbcTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DatabaseService {

    private final JdbcTemplateRepository jdbcTemplateRepository;

    @Transactional
    public void initializeTodayNews() {
        jdbcTemplateRepository.initializeDatabase();
    }

}
