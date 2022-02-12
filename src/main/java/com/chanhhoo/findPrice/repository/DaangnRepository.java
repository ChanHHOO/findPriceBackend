package com.chanhhoo.findPrice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.chanhhoo.findPrice.domain.DaangnEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DaangnRepository extends JpaRepository<DaangnEntity, Long> {

    @Query(value = "SELECT * FROM daangn_entity WHERE article_title = :articleTitle", nativeQuery = true)
    List<DaangnEntity> findByArticleTitle(@Param(value = "articleTitle") String articleTitle);

}
