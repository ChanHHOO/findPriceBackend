package project.service;

import project.mapper.DaangnMapper;
import project.vo.DaangnVO;

import java.util.List;
import java.io.IOException;
import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



@Service
public class DaangnService {

    @Autowired
    public DaangnMapper mapper;
    DaangnVO daangnVO;
    //WebDriver setup
    private WebDriver driver;
    private WebElement element;
    
    
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
    //javaws 찾아내기.
    
    public void getDaangnSearchedDatas() throws IOException{
        DAANGN_URL += daangnVO.getSearchItem();
        seleniumSetup();
        
        element = driver.findElement(By.className("more-btn"));
        element.click();
        System.out.println("");
        
    }

    public List<DaangnVO> searchItemPrice(){
        return mapper.searchItemPrice();
    }
}
