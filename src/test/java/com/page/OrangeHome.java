package com.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.springframework.boot.SpringApplication;

import com.example.demo.OpenBrowser;

public class OrangeHome {
    @FindBy(name = "username")
    private WebElement textusername;

    @FindBy(name = "password")
    private WebElement textpassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnsubmit;
    private WebDriver driver;
    // public WebDriver getDriver(){
    //     return driver;
    // }

    public void openUrl(){
        SpringApplication.run(OpenBrowser.class);
		System.setProperty("webdriver.chrome.driver","D:\\project\\chromedriver_win32\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		String baseUrl = "https://opensource-demo.orangehrmlive.com";
		driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    public void login(String username, String password){
        driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

    }
    public void Navigate(){   
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
    }
    public void getText(){   
		String username = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).getText();
        System.out.println(username);
    }
}
