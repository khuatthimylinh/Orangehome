package com.page;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.testng.annotations.AfterClass;

import com.example.demo.OpenBrowserTest;

public class LoginPage extends BaseTest{
   
    OpenBrowserTest openBrowser;
    WebDriverWait wait;
    
    private By txtUsername = (By.name("username"));
    private By txtPassword = (By.name("password"));
    private By btnSubmit = By.xpath("//button[@type='submit']");
    private By logoIcon = By.xpath("//div[@class='oxd-brand-banner']");
     
    public void login(String username, String password){
        openUrl();
        driver.findElement(txtUsername).sendKeys(username);

		driver.findElement(txtPassword).sendKeys(password);

		driver.findElement(btnSubmit).click();

    }
    public boolean isLogoDisplay(){
        return driver.findElement(logoIcon).isDisplayed();
    }
    
}
