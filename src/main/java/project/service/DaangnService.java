package project.service;

import project.mapper.DaangnMapper;
import project.vo.DaangnVO;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import javax.annotation.PostConstruct;


@Service
public class DaangnService {

    @Autowired
    public DaangnVO daangnVO;

    @Autowired
    public DaangnMapper mapper;
    
    //WebDriver setup
    private static WebDriver driver;
    private WebElement moreBtn;
    private List <WebElement> articleImg;
    private List <WebElement> articlePrice;
    private List <WebElement> articleObj;

    //Properties setup
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "chromedriver.exe";
    private static String DAANGN_URL = "https://www.daangn.com/search/";

    //local val
    int articleCount = 0;
    int avrItemPrice = 0;
    int maxItemPrice = -1;
    int minItemPrcie = Integer.MAX_VALUE;
    String maxImgStr;
    String minImgStr;
    String maxArticleTitle;
    String minArticleTitle;
    String updateTime;
    private List<Integer> articlePriceList;

    //selenium setup
    public void seleniumSetup(){
        //System Property Setup
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        
        //Driver Setup
        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        
        //do not show browser and etc..
        //options.addArguments("--headless"); // << without new browser
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        driver = new ChromeDriver(options);
    
        driver.get(DAANGN_URL);
    }
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    public List<DaangnVO> getDaangnSearchedData(String searchedItem){
        // System.out.println(mapper.selectDaangnSearcedDatas(searchedItem).getArticle_title());
        
        return mapper.selectDaangnSearcedDatas(searchedItem);
    }
    public void setDaangnSearchedData(String searchedItem){

        mapper.insertDaangnSearcedDatas(
            searchedItem, 
            maxArticleTitle,
            minArticleTitle,
            maxImgStr, 
            minImgStr, 
            avrItemPrice, 
            maxItemPrice, 
            minItemPrcie,
            articleCount);
        // list.forEach(System.out::println);
    }


    public List<DaangnVO> updateDaangnSearchedData(String searchItem) throws IOException{
        DAANGN_URL += searchItem;
        System.out.println(DAANGN_URL);
        seleniumSetup();

        try{
            moreBtn = driver.findElement(By.className("more-btn"));
            for(int count = 0 ; count < 50; count++){
                moreBtn.click();
            }
            // 브라우저에 출력하는 시간을 고려하여 10초 대기.
            Thread.sleep(1000);

            articlePrice = driver.findElements(By.className("article-price"));
            articleImg = driver.findElements(By.className("card-photo"));
            System.out.println(articlePrice.size() +"<<<<<>>>>>>"+articleImg.size());
            articleObj = driver.findElements(By.className("flea-market-article-link"));
            System.out.println(articleObj.get(0).findElement(By.className("article-title")).getText());
            
            
        }catch(InterruptedException  e){
            DAANGN_URL = "https://www.daangn.com/search/";
            e.printStackTrace();
        } finally{
            DAANGN_URL = "https://www.daangn.com/search/";
        }

        int idx = 0;
            for(idx = 0 ; idx < articlePrice.size(); idx++){
                String priceStr = String.join("", articleObj.get(idx).findElement(By.className("article-price")).getAttribute("innerText").substring(0, articlePrice.get(idx).getAttribute("innerText").length()-1).split(","));
                String imgStr = articleObj.get(idx).findElement(By.tagName("img")).getAttribute("src");
                if(isInteger(priceStr)){
                    Integer price = Integer.parseInt(priceStr.join("", priceStr));
                    avrItemPrice += price;
                    articleCount += 1;
                    if(price > maxItemPrice){
                        maxItemPrice = price;
                        maxImgStr = imgStr;
                        maxArticleTitle = articleObj.get(idx).findElement(By.className("article-title")).getText();
                        
                    }
                    if(price < minItemPrcie){
                        minItemPrcie = price;
                        minImgStr = imgStr;
                        minArticleTitle = articleObj.get(idx).findElement(By.className("article-title")).getText();
                    }
                }
            }
            
        avrItemPrice /= articleCount;
        DAANGN_URL = "https://www.daangn.com/search/";
        setDaangnSearchedData(searchItem);
        
        return getDaangnSearchedData(searchItem);
    }
    public List<DaangnVO> searchItemPrice(){

        return mapper.searchItemPrice();
    }
}