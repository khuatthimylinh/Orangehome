package com.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.springframework.boot.SpringApplication;

import com.example.demo.OpenBrowserTest;

public class OrangeHomePage {
   
    private WebDriver driver;
    OpenBrowserTest openBrowser;
    public String chromePath = "D:\\project\\chromedriver_win32\\chromedriver.exe";
    public String Url = "https://opensource-demo.orangehrmlive.com/";

    public void openUrl(){
        SpringApplication.run(OpenBrowserTest.class);
        System.setProperty("webdriver.chrome.driver",chromePath);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get(Url);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    public void login(String username, String password){
        openUrl();
        driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
    public void Navigate(){  
        
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
    }

    public void getAccount(){

		String username = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).getText();
        System.out.println(username);
    }

    public boolean isloginDisplay(){
        return driver.findElement(By.xpath("//h5")).isDisplayed();
    }

    public boolean isUsernameDisplay(){
        return driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).isDisplayed();
    }

    public boolean isAdminpageDisplay(){
        return driver.findElement(By.xpath("//h6")).isDisplayed();
    }
    
}
