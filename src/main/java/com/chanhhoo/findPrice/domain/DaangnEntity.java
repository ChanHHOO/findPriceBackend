package main.java.com.chanhhoo.findPrice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@NoArgsConstructor
@Entity
public class DaangnEntity {

    private String article_id;
    private String article_title;
    private String article_avrPrice;
    private String article_maxPrice;
    private String article_minPrice;
    private String article_maxImgStr;
    private String article_minImgStr;
    private String article_maxArticleTitle;
    private String article_minArticleTitle;
    private String article_count;
    private String article_updateTime;
    private String chartDomain_firstX;
    private String chartDomain_secondX;
    private String chartDomain_thirdX;
    private String chartDomain_fourthX;
    private int chartData_firstY;
    private int chartData_secondY;
    private int chartData_thirdY;
    private int chartData_fourthY;


    // @Builder
    // public TestEntity(String content){
    //     this.content = content;
    // }
    
    // @Column(length = 500, nullable = false)
    // private String title;

    // public void update(Long id, String content){
    //     this.content = content;
    // }

    // private String author;

}
