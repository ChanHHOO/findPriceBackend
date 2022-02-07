package com.chanhhoo.findprice.service;

// import project.mapper.DaangnMapper;
// import project.vo.DaangnVO;
// import project.service.ChartDataManufacture;

import com.chanhhoo.findprice.dto.DaangnDto;
import com.chanhhoo.findprice.dto.DaangnResponseDto;
import com.chanhhoo.findprice.repository.DaangnRepository;
//import com.chanhhoo.findprice.repository.DaangnRepository;
import com.chanhhoo.findprice.domain.DaangnEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.List;
import java.beans.Transient;
import java.io.IOException;
import java.sql.Date;
import java.util.Map.Entry;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.transaction.annotation.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class DaangnService {

    private DaangnDto daangnDto;

    @Autowired
    private DaangnRepository daangnRepository;

    public ChartDataManufacture chartObj;

    // WebDriver setup
    private static WebDriver driver;
    private WebElement moreBtn;
    private List<WebElement> articleImg;
    private List<WebElement> articlePrice;
    private List<WebElement> articleObj;

    // Properties setup
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "chromedriver.exe";
    private static String DAANGN_URL = "https://www.daangn.com/search/";

    // log
    private static Logger logger = LogManager.getLogger(DaangnService.class);

    // local val
    int articleCount = 0;
    int avrItemPrice = 0;
    int maxItemPrice = -1;
    int minItemPrcie = Integer.MAX_VALUE;
    int updateFuncCallCount = 0;
    String maxImgStr;
    String minImgStr;
    String maxArticleTitle;
    String minArticleTitle;
    String updateTime;
    List<Integer> articlePriceList = new ArrayList<Integer>();

    public void DaangnService() {
        System.out.println("service thread start");
    }

    // selenium setup
    public void seleniumSetup() {
        // System Property Setup
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        // Driver Setup
        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);

        // do not show browser and etc..
        options.addArguments("--headless"); // << without new browser
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        driver.get(DAANGN_URL);
    }

    public void initialSet() {
        maxItemPrice = -1;
        minItemPrcie = Integer.MAX_VALUE;
        articleCount = 0;
        updateFuncCallCount = 0;
        articlePriceList = new ArrayList<Integer>();
        System.out.println("init!");
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    // public List<DaangnVO> getDaangnSearchedData(String searchedItem) throws IOException {

    //     List<DaangnVO> searchedData = mapper.selectDaangnSearcedDatas(searchedItem);
    //     if (searchedData.isEmpty()) {
    //         updateDaangnSearchedData(searchedItem, "getDaangnSearchedData");
    //         searchedData = mapper.selectDaangnSearcedDatas(searchedItem);
    //     }
    //     return searchedData;

    // }
    
    @Transactional
    public DaangnResponseDto findByTitle(String searchedItem) throws IOException{
        List<DaangnEntity> daangnEntity = daangnRepository.findByArticleTitle(searchedItem);
        if(daangnEntity.isEmpty()){
            updateDaangnSearchedData(searchedItem, "getDaangnSearchedData");
        }
        return null;
    }

    @Transactional
    public void setDaangnSearchedData() {

        // insert code
        daangnRepository.save(daangnDto.toEntity());

        initialSet();

    }

    public DaangnResponseDto updateDaangnSearchedData(String searchItem, String callFunction) throws IOException {
        DAANGN_URL += searchItem;
        seleniumSetup();
        initialSet();

        try {
            moreBtn = driver.findElement(By.className("more-btn"));
            for (int count = 0; count < 10; count++) {
                moreBtn.click();
            }
            // 브라우저에 출력하는 시간을 고려하여 2초 대기.
            Thread.sleep(1000);

            articlePrice = driver.findElements(By.className("article-price"));
            articleImg = driver.findElements(By.className("card-photo"));
            articleObj = driver.findElements(By.className("flea-market-article-link"));

        } catch (InterruptedException e) {
            DAANGN_URL = "https://www.daangn.com/search/";
            e.printStackTrace();
        } catch (NoSuchWindowException e) {
            DAANGN_URL = "https://www.daangn.com/search/";
            e.printStackTrace();
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            if (updateFuncCallCount <= 3) {
                updateFuncCallCount += 1;
                DAANGN_URL = "https://www.daangn.com/search/";
                updateDaangnSearchedData(searchItem, callFunction);
            } else {
                e.printStackTrace();
            }
        } finally {
            DAANGN_URL = "https://www.daangn.com/search/";
        }

        int idx = 0;
        for (idx = 0; idx < articlePrice.size(); idx++) {
            String priceStr = String.join("",
                    articleObj.get(idx).findElement(By.className("article-price")).getAttribute("innerText")
                            .substring(0, articlePrice.get(idx).getAttribute("innerText").length() - 1).split(","));
            String imgStr = articleObj.get(idx).findElement(By.tagName("img")).getAttribute("src");
            if (isInteger(priceStr)) {
                Integer price = Integer.parseInt(priceStr.join("", priceStr));
                avrItemPrice += price;
                articleCount += 1;

                articlePriceList.add(price);

                if (price > maxItemPrice) {
                    maxItemPrice = price;
                    maxImgStr = imgStr;
                    maxArticleTitle = articleObj.get(idx).findElement(By.className("article-title")).getText();

                }
                if (price < minItemPrcie) {
                    minItemPrcie = price;
                    minImgStr = imgStr;
                    minArticleTitle = articleObj.get(idx).findElement(By.className("article-title")).getText();
                }
            }
        }
        avrItemPrice /= articleCount;
        DAANGN_URL = "https://www.daangn.com/search/";

        // get chartdata
        System.out.println(articlePriceList.get(1) + " " + maxItemPrice + " " + articleCount);
        chartObj.getDomainData(articlePriceList, maxItemPrice / 4, articleCount);

        // mapping data from web to dto
        daangnDto.setArticle_title(searchItem);
        daangnDto.setArticle_avrPrice(avrItemPrice);
        daangnDto.setArticle_maxPrice(maxItemPrice);
        daangnDto.setArticle_minPrice(minItemPrcie);
        daangnDto.setArticle_maxImgStr(maxImgStr);
        daangnDto.setArticle_minImgStr(minImgStr);
        daangnDto.setArticle_maxArticleTitle(maxArticleTitle);
        daangnDto.setArticle_minArticleTitle(minArticleTitle);
        daangnDto.setArticle_count(articleCount);
        daangnDto.setArticle_updateTime(new Date(System.currentTimeMillis()));
        daangnDto.setChartDomain_firstX(chartObj.xDomain.get(0));
        daangnDto.setChartDomain_secondX(chartObj.xDomain.get(1));
        daangnDto.setChartDomain_thirdX(chartObj.xDomain.get(2));
        daangnDto.setChartDomain_fourthX(chartObj.xDomain.get(4));
        daangnDto.setChartData_firstY(chartObj.chartData.get(0));
        daangnDto.setChartData_secondY(chartObj.chartData.get(1));
        daangnDto.setChartData_thirdY(chartObj.chartData.get(2));
        daangnDto.setChartData_fourthY(chartObj.chartData.get(3));

        setDaangnSearchedData();
        if (callFunction == "getDaangnSearchedData") {
            return null;
        }
        return findByTitle(searchItem);
    }
}