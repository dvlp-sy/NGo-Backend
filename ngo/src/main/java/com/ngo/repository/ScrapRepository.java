package com.ngo.repository;

import com.ngo.model.Scrap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * ==== ScrapRepository Interface ====
 * @package : com.ngo.repository
 * @name : ScrapRepository.java
 * @date : 2024. 04. 20.
 * @author : siyunsmacbook
*/

@RepositoryRestResource
public interface ScrapRepository extends JpaRepository<Scrap, Long>
{
    public List<Scrap> findByUser_UserId(Long userId);
}
