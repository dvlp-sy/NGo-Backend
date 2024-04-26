package com.ngo.controller;

import com.ngo.service.RankService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankController
{
    private final RankService rankService;

    public RankController(RankService rankService) { this.rankService = rankService; }
}
