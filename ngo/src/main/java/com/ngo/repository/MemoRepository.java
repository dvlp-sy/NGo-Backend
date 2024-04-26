package com.ngo.repository;

import com.ngo.model.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MemoRepository extends JpaRepository<Memo, Long>
{

}