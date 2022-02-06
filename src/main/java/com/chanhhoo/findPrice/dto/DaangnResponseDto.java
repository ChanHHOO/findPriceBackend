package com.chanhhoo.findprice.dto;

import java.sql.Date;

import com.chanhhoo.findprice.domain.DaangnEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//import com.study.project.domain.TestEntity;

@Getter
@NoArgsConstructor
public class DaangnResponseDto {

    private Long article_id;
    private String article_title;
    private int article_avrPrice;
    private int article_maxPrice;
    private int article_minPrice;
    private String article_maxImgStr;
    private String article_minImgStr;
    private String article_maxArticleTitle;
    private String article_minArticleTitle;
    private int article_count;
    private Date article_updateTime;
    private String chartDomain_firstX;
    private String chartDomain_secondX;
    private String chartDomain_thirdX;
    private String chartDomain_fourthX;
    private int chartData_firstY;
    private int chartData_secondY;
    private int chartData_thirdY;
    private int chartData_fourthY;

    @Builder
    public DaangnResponseDto(DaangnEntity entity){
        this.article_id = entity.getArticle_id();
        this.article_title = entity.getArticle_title();
        this.article_avrPrice = entity.getArticle_avrPrice();
        this.article_maxPrice = entity.getArticle_maxPrice();
        this.article_minPrice = entity.getArticle_minPrice();
        this.article_maxImgStr = entity.getArticle_maxImgStr();
        this.article_minImgStr = entity.getArticle_minImgStr();
        this.article_minArticleTitle = entity.getArticle_minArticleTitle();
        this.article_maxArticleTitle = entity.getArticle_maxArticleTitle();
        this.article_count = entity.getArticle_count();
        this.article_updateTime = entity.getArticle_updateTime();
        this.chartDomain_firstX = entity.getChartDomain_firstX();
        this.chartDomain_secondX = entity.getChartDomain_secondX();
        this.chartDomain_thirdX = entity.getChartDomain_thirdX();
        this.chartDomain_fourthX = entity.getChartDomain_fourthX();
        this.chartData_firstY = entity.getChartData_firstY();
        this.chartData_secondY = entity.getChartData_secondY();
        this.chartData_thirdY = entity.getChartData_thirdY();
        this.chartData_fourthY = entity.getChartData_fourthY();
    }
}
