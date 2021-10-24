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