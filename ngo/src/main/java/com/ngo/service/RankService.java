package com.ngo.service;

import com.ngo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RankService
{
    private final UserRepository userRepository;

    public RankService(UserRepository userRepository) { this.userRepository = userRepository; }
}
