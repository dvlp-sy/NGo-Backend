package com.ngo.repository;

import com.ngo.model.TodayNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TodayNewsRepository extends JpaRepository<TodayNews, Integer>
{
    List<TodayNews> findAllByLevel(String level);
}
