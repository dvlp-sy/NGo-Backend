package com.ngo.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryMediaRepository implements MediaRepository
{
    private Map<String, String> media = new HashMap<>();

    public MemoryMediaRepository()
    {
        media.put("경향신문", "032");
        media.put("국민일보", "005");
        media.put("동아일보", "020");
        media.put("문화일보", "021");
        media.put("서울신문", "081");
        media.put("세계일보", "022");
        media.put("조선일보", "023");
        media.put("중앙일보", "025");
        media.put("한겨레", "028");
        media.put("한국일보", "469");
    }

    @Override
    public Map<String, String> getAllMedia()
    {
        return media;
    }
}
