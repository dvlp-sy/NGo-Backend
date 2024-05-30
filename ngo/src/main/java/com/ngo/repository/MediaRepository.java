package com.ngo.repository;

import com.ngo.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Map;

/**
 * ==== MediaRepository Interface ====
 * @package : com.ngo.repository
 * @name : MediaRepository.java
 * @date : 2024. 05. 10.
 * @author : siyunsmacbook
*/

@Repository
public interface MediaRepository extends JpaRepository<Media, Long>
{

}
