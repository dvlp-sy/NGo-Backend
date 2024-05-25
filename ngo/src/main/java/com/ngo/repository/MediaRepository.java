package com.ngo.repository;

import com.ngo.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long>
{

}
