package com.page;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;

import com.example.demo.OpenBrowserTest;

import bsh.org.objectweb.asm.Constants;

public class PunchINOutPage extends BaseTest{

    private WebDriverWait wait;
    
    private By lbTime = By.xpath("//span[text()='Time']");
    private By lbattendance = By.xpath("//span[text()='Attendance ']");
    private By lbPunchInOut = By.xpath("//a[text()='Punch In/Out']");
    private By btnIn = By.xpath("//button[text()=' In ']");
    private By txtTime = By.xpath("(//input[contains(@class,'oxd-input')])[3]");
    private By btnOut = By.xpath("//div[@class='oxd-form-actions']/button[text()=' Out ']");
    private By msgSuccess = By.xpath("//p[text()='Successfully Saved']");
    private By lblMyRecords = By.xpath("//a[text()='My Records']");

    //Information My Record after edit
    private By punchIn = By.xpath("(//p[@class='oxd-text oxd-text--p'])[1]");
    private By punchOut = By.xpath("(//p[@class='oxd-text oxd-text--p'])[2]");
    
    public void UpdatePunchIn(String timeIn) throws InterruptedException{  
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    driver.findElement(lbTime).click();
        driver.findElement(lbattendance).click();
        driver.findElement(lbPunchInOut).click();

        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(txtTime));
        driver.findElement(txtTime).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        driver.findElement(txtTime).sendKeys(timeIn);
        driver.findElement(btnIn).click();

    }

    public void UpdatePunchOut(String timeOut){  
        
        wait.until(ExpectedConditions.elementToBeClickable(txtTime));
        driver.findElement(txtTime).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        driver.findElement(txtTime).sendKeys(timeOut);
        driver.findElement(btnOut).click();

    }

    public void checkoutMyrecord(){
        driver.findElement(lbattendance).click();
        driver.findElement(lblMyRecords).click();
        
    }

    public String getPunchIn(){
        WebElement in = driver.findElement(punchIn);
        System.out.println("Actual result of Punch In: "+ in.getText());
        return in.getText();
    }

    public String getPunchOut(){
        WebElement out = driver.findElement(punchOut);
        System.out.println("Actual result of Punch Out: "+ out.getText());
        return out.getText();
    }

    public String msgSuccessDisplay(){
        WebElement Success = wait.until(ExpectedConditions.visibilityOfElementLocated(msgSuccess)); 
        System.out.println(Success.getText());
         return Success.getText();
        
    }
    
   
}
