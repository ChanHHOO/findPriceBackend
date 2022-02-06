package com.chanhhoo.findprice.dto;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class DaangnDto{

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
}