package com.ngo.repository;

import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
public interface MediaRepository
{
    Map<String, String> getAllMedia();
}
