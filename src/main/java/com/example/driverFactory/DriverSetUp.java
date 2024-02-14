package com.example.driverFactory;

import com.example.functions.ActionClass;
import com.example.functions.AssertionsClass;
import com.example.functions.ElementsClass;
import com.example.functions.WaitersClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import java.time.Duration;
//import java.util.concurrent.TimeUnit;

public class DriverSetUp {
    static ActionClass action;
    static AssertionsClass assertions;
    static ElementsClass elements;
    static WaitersClass waiters;
    private static WebDriver driver;

    private static WebDriver setUpDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        // driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        // driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        
        action = new ActionClass(driver);
        assertions = new AssertionsClass(driver);
        elements = new ElementsClass(driver);
        waiters = new WaitersClass(driver);
        return driver;
    }

    private static WebDriver getInstance(){
        if(driver == null){
            try {
                driver = setUpDriver();
            } catch (Exception e){
                e.printStackTrace();
            }
        }return driver;
    }

    public static WebDriver startChromeDriver(){
        driver = getInstance();
        return driver;
    }
}
