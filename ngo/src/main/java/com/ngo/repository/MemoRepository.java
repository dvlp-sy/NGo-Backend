package com.ngo.repository;

import com.ngo.model.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * ==== MemoRepository Interface ====
 * @package : 2024. 04. 24.
 * @name : MemoRepository.java
 * @date : 
 * @author : siyunsmacbook
*/

@RepositoryRestResource
public interface MemoRepository extends JpaRepository<Memo, Long>
{
    public List<Memo> findByScrap_ScrapId(Long scrapId);
}
