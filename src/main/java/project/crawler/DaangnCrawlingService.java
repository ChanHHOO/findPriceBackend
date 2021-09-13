//https://joooootopia.tistory.com/26  참고자료
package project.crawler;

import project.vo.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.jsoup.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Service
public class DaangnCrawlingService {
    //WebDriver setup
    private WebDriver driver;
    private WebElement element;
    private String url;
    
    //Properties setup
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "chromedriver.exe";
    private static String DAANGN_SEARCHED_DATA_URL = "https://www.daangn.com/search/%EC%8A%A4%ED%83%A0%EB%93%9C%EC%A1%B0%EB%AA%85";
    
    //selenium setup
    public void seleniumSetup(){
        //System Property Setup
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
        
        //Driver Setup
        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        
        //do not show browser and etc..
        options.addArguments("--headless"); // << without new browser
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        driver = new ChromeDriver(options);
    
        driver.get(DAANGN_SEARCHED_DATA_URL);
    }
    //javaws 찾아내기.
    @PostConstruct
    public void getDaangnSearchedDatas() throws IOException{
        
        seleniumSetup();
        
        element = driver.findElement(By.className("more-btn"));
        element.click();
        System.out.println(">>>>>>>>>>>>"+element.getText());
        
    }
}

