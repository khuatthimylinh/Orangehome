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
    

    public void openUrl(){
        SpringApplication.run(OpenBrowserTest.class);
		System.setProperty("webdriver.chrome.driver","D:\\project\\chromedriver_win32\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		String baseUrl = "https://opensource-demo.orangehrmlive.com";
		driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    public void login(){
        openUrl();
        driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
    public void Navigate(){ 
        login();  
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
    }
    public void getAccount(){  
        login(); 
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
