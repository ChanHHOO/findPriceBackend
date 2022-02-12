package com.chanhhoo.findPrice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.chanhhoo.findPrice.dto.DaangnDto;

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

    @Builder
    public DaangnEntity(DaangnDto daangnDto){
        //this.article_id = daangnDto.getArticle_id();

        this.article_title = daangnDto.getArticle_title();

        this.article_avrPrice = daangnDto.getArticle_avrPrice();

        this.article_maxPrice = daangnDto.getArticle_maxPrice();

        this.article_minPrice = daangnDto.getArticle_minPrice();

        this.article_maxImgStr = daangnDto.getArticle_maxImgStr();

        this.article_minImgStr = daangnDto.getArticle_minImgStr();

        this.article_maxArticleTitle = daangnDto.getArticle_maxArticleTitle();

        this.article_minArticleTitle = daangnDto.getArticle_minArticleTitle();

        this.article_count = daangnDto.getArticle_count();

        this.article_updateTime = daangnDto.getArticle_updateTime();
        
        this.chartDomain_firstX = daangnDto.getChartDomain_firstX();
        
        this.chartDomain_secondX = daangnDto.getChartDomain_secondX();

        this.chartDomain_thirdX = daangnDto.getChartDomain_thirdX();
        
        this.chartDomain_fourthX = daangnDto.getChartDomain_fourthX();
        
        this.chartData_firstY = daangnDto.getChartData_firstY();
        
        this.chartData_secondY = daangnDto.getChartData_secondY();

        this.chartData_thirdY = daangnDto.getChartData_thirdY();

        this.chartData_fourthY = daangnDto.getChartData_fourthY();
        
    }
}
