package com.chanhhoo.findprice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class DaangnEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long article_id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String article_title;

    @Column(columnDefinition = "integer", nullable = false)
    private Integer article_avrPrice;

    @Column(columnDefinition = "integer", nullable = false)
    private Integer article_maxPrice;

    @Column(columnDefinition = "integer", nullable = false)
    private Integer article_minPrice;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String article_maxImgStr;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String article_minImgStr;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String article_maxArticleTitle;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String article_minArticleTitle;

    @Column(columnDefinition = "integer", nullable = false)
    private Integer article_count;

    @Column(columnDefinition = "date", nullable = false)
    private Date article_updateTime;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String chartDomain_firstX;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String chartDomain_secondX;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String chartDomain_thirdX;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String chartDomain_fourthX;

    @Column(columnDefinition = "integer", nullable = false)
    private int chartData_firstY;

    @Column(columnDefinition = "integer", nullable = false)
    private int chartData_secondY;

    @Column(columnDefinition = "integer", nullable = false)
    private int chartData_thirdY;

    @Column(columnDefinition = "integer", nullable = false)
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
