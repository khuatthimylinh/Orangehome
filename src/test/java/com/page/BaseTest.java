package com.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.example.demo.OpenBrowserTest;

public class BaseTest {
    protected static WebDriver driver;
    public String chromePath = "D:\\project\\chromedriver_win32\\chromedriver.exe";
    public String Url = "https://opensource-demo.orangehrmlive.com/";

    
    public void openUrl(){
        SpringApplication.run(OpenBrowserTest.class);
        System.setProperty("webdriver.chrome.driver",chromePath);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get(Url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void explicitWaitForVisible(int seconds, By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void tearDown(WebDriver driver) {
        driver.close();
        driver.quit();
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
