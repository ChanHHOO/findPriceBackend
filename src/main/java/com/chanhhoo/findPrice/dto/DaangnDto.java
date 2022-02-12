package com.chanhhoo.findPrice.dto;

import java.sql.Date;

import com.chanhhoo.findPrice.domain.DaangnEntity;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DaangnDto{

    @Autowired
    private DaangnEntity entity;

    private Long article_id;
    private String article_title;
    private Integer article_avrPrice;
    private Integer article_maxPrice;
    private Integer article_minPrice;
    private String article_maxImgStr;
    private String article_minImgStr;
    private String article_maxArticleTitle;
    private String article_minArticleTitle;
    private Integer article_count;
    private Date article_updateTime;
    private String chartDomain_firstX;
    private String chartDomain_secondX;
    private String chartDomain_thirdX;
    private String chartDomain_fourthX;
    private Integer chartData_firstY;
    private Integer chartData_secondY;
    private Integer chartData_thirdY;
    private Integer chartData_fourthY;

    public DaangnEntity toEntity(){

        return entity.builder().daangnDto(this).build();

    }

}