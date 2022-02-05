package main.java.com.chanhhoo.findPrice.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaangnRepository extends JpaRepository<TestEntity, Long> {
    @Query("SELECT * FROM articles WHERE article_title = :articleTitle")
    List<Account> findByArticleTtile(@Param("articleTitle") String articleTitle);
}
