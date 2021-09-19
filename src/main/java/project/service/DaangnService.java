package project.service;

import project.mapper.DaangnMapper;
import project.vo.DaangnVO;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.io.IOException;



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
    private WebDriver driver;
    private WebElement moreBtn;
    private List <WebElement> articleTitle;
    private List <WebElement> articlePrice;
    
    //Properties setup
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "chromedriver.exe";
    private static String DAANGN_URL = "https://www.daangn.com/search/";
    
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
    
    public void getDaangnSearchedData(String searchItem) throws IOException{
        DAANGN_URL += searchItem;
        seleniumSetup();
        
        try{
            moreBtn = driver.findElement(By.className("more-btn"));
            for(int count = 0 ; count < 50; count++){
                
                moreBtn.click();
            }
            // 브라우저에 출력하는 시간을 고려하여 10초 대기.
            Thread.sleep(10000);
            articlePrice = driver.findElements(By.className("article-price"));
            articleTitle = driver.findElements(By.className("article-title"));
            
            System.out.println();
            Map<String, Integer> aricleData = new HashMap<String, Integer>();
            for(int i = 0 ; i < articlePrice.size(); i++){
                String[] ss = articlePrice.get(i).getAttribute("innerText").substring(0, articlePrice.get(0).getAttribute("innerText").length()-1).split(",");
                String s = String.join("", ss);
                System.out.println(s);
                // Integer price = Integer.parseInt();
                // System.out.println(price);
                // aricleData.put(articleTitle, price);
                
            }
            DAANGN_URL = "https://www.daangn.com/search/";
            
        }catch(InterruptedException  e){
            DAANGN_URL = "https://www.daangn.com/search/";
            e.printStackTrace();
        }
        
        // price info
        //document.getElementsByClassName("flea-market-article-link")[0].getElementsByClassName("article-price")[0].innerText
        
        
    }
    public List<DaangnVO> searchItemPrice(){

        return mapper.searchItemPrice();
    }
}