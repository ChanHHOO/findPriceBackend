package project.vo;

import lombok.*;

import org.springframework.stereotype.Repository;


@Getter
@Setter
@Repository
public class DaangnVO{

    private String itemTitle;
    private String itemPrice;
    public String searchItem;
    public String searchCategory;

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

    public String getChartDomain_firstX() {
        return this.chartDomain_firstX;
    }

    public void setChartDomain_firstX(String chartDomain_firstX) {
        this.chartDomain_firstX = chartDomain_firstX;
    }

    public String getChartDomain_secondX() {
        return this.chartDomain_secondX;
    }

    public void setChartDomain_secondX(String chartDomain_secondX) {
        this.chartDomain_secondX = chartDomain_secondX;
    }

    public String getChartDomain_thirdX() {
        return this.chartDomain_thirdX;
    }

    public void setChartDomain_thirdX(String chartDomain_thirdX) {
        this.chartDomain_thirdX = chartDomain_thirdX;
    }

    public String getChartDomain_fourthX() {
        return this.chartDomain_fourthX;
    }

    public void setChartDomain_fourthX(String chartDomain_fourthX) {
        this.chartDomain_fourthX = chartDomain_fourthX;
    }

    public int getChartData_firstY() {
        return this.chartData_firstY;
    }

    public void setChartData_firstY(int chartData_firstY) {
        this.chartData_firstY = chartData_firstY;
    }

    public int getChartData_secondY() {
        return this.chartData_secondY;
    }

    public void setChartData_secondY(int chartData_secondY) {
        this.chartData_secondY = chartData_secondY;
    }

    public int getChartData_thirdY() {
        return this.chartData_thirdY;
    }

    public void setChartData_thirdY(int chartData_thirdY) {
        this.chartData_thirdY = chartData_thirdY;
    }

    public int getChartData_fourthY() {
        return this.chartData_fourthY;
    }

    public void setChartData_fourthY(int chartData_fourthY) {
        this.chartData_fourthY = chartData_fourthY;
    }

    public String getArticle_maxArticleTitle() {
        return this.article_maxArticleTitle;
    }

    public void setArticle_maxArticleTitle(String article_maxArticleTitle) {
        this.article_maxArticleTitle = article_maxArticleTitle;
    }

    public String getArticle_minArticleTitle() {
        return this.article_minArticleTitle;
    }

    public void setArticle_minArticleTitle(String article_minArticleTitle) {
        this.article_minArticleTitle = article_minArticleTitle;
    }

    public String getArticle_count() {
        return this.article_count;
    }

    public void setArticle_count(String article_count) {
        this.article_count = article_count;
    }

    public String getArticle_updateTime() {
        return this.article_updateTime;
    }

    public void setArticle_updateTime(String article_updateTime) {
        this.article_updateTime = article_updateTime;
    }

    public String getArticle_id() {
        return this.article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getArticle_title() {
        return this.article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_avrPrice() {
        return this.article_avrPrice;
    }

    public void setArticle_avrPrice(String article_avrPrice) {
        this.article_avrPrice = article_avrPrice;
    }

    public String getArticle_maxPrice() {
        return this.article_maxPrice;
    }

    public void setArticle_maxPrice(String article_maxPrice) {
        this.article_maxPrice = article_maxPrice;
    }

    public String getArticle_minPrice() {
        return this.article_minPrice;
    }

    public void setArticle_minPrice(String article_minPrice) {
        this.article_minPrice = article_minPrice;
    }

    public String getArticle_maxImgStr() {
        return this.article_maxImgStr;
    }

    public void setArticle_maxImgStr(String article_maxImgStr) {
        this.article_maxImgStr = article_maxImgStr;
    }

    public String getArticle_minImgStr() {
        return this.article_minImgStr;
    }

    public void setArticle_minImgStr(String article_minImgStr) {
        this.article_minImgStr = article_minImgStr;
    }

    public String getSearchCategory() {
        return this.searchCategory;
    }

    public void setSearchCategory(String searchCategory) {
        this.searchCategory = searchCategory;
    };
    
    public String getSearchItem() {
        return this.searchItem;
    }

    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }

    public String getItemTitle() {
        return this.itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemPrice() {
        return this.itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }


    // 데이터 가공 코드 첨가 
}