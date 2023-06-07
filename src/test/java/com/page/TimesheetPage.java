package com.page;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.demo.OpenBrowserTest;

import common.BaseTest;

public class TimesheetPage extends BaseTest{

    private WebDriverWait wait;
    

    private By lbTime = By.xpath("//span[text()='Time']");
    private By lbtimesheet = By.xpath("//span[text()='Timesheets ']");
    private By lbMytimesheet = By.xpath("//a[text()='My Timesheets']");
    private By btnEdit = By.xpath("//button[text()=' Edit ']");
    private By txtProjectName = By.xpath("//input[@placeholder='Type for hints...']");
    private By dpdProjectName = By.xpath("//span[text()='The Coca-Cola Company - Coke - Phase 1']");
    private By txtActivity = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    private By dpdActivity = By.xpath("//span[text()='Administration']");
    private By txttime1 = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[2]");
    private By txttime2 = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[3]");
    private By txttime3 = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[4]");
    private By txttime4 = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[5]");
    private By txttime5 = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[6]");
    private By txttime6 = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[7]");
    private By txttime7 = By.xpath("(//input[contains(@class,'oxd-input oxd-input')])[8]");
    private By btnSave = By.xpath("//button[text()=' Save ']");
    private By messageSuccess = By.xpath("//p[text()='Successfully Saved']");

    //Information timesheet after edit
    private By project = By.xpath("(//td[contains(@class,'orangehrm-timesheet')])[1]");
    private By activity = By.xpath("(//td[contains(@class,'orangehrm-timesheet')])[2]");
    private By Mon = By.xpath("(//td[contains(@class,'orangehrm-timesheet')])[3]");
    private By Tue = By.xpath("(//td[contains(@class,'orangehrm-timesheet')])[4]");
    private By Wed = By.xpath("(//td[contains(@class,'orangehrm-timesheet')])[5]");
    private By Thu = By.xpath("(//td[contains(@class,'orangehrm-timesheet')])[6]");
    private By Fri = By.xpath("(//td[contains(@class,'orangehrm-timesheet')])[7]");
    private By Sat = By.xpath("(//td[contains(@class,'orangehrm-timesheet')])[8]");
    private By Sun = By.xpath("(//td[contains(@class,'orangehrm-timesheet')])[9]");
    

    
    
    public void EditMyTimesheet(String project, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) throws InterruptedException{  
        
        //Thread.sleep(3000);

	    driver.findElement(lbTime).click();
        driver.findElement(lbtimesheet).click();
        driver.findElement(lbMytimesheet).click();
        driver.findElement(btnEdit).click();

        //edit failed
        // driver.findElement(txtProjectName).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        // driver.findElement(txtProjectName).click();
        // driver.findElement(txtProjectName).sendKeys(project);
        // wait.until(ExpectedConditions.elementToBeClickable(dpdProjectName));
        // driver.findElement(dpdProjectName).click();
        
        //edit passed
        for (int i = 0; i <= 1; i++) {
            driver.findElement(txtProjectName).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
            driver.findElement(txtProjectName).click();
            driver.findElement(txtProjectName).sendKeys(project);
            Thread.sleep(2000);
            // wait.until(ExpectedConditions.elementToBeClickable(dpdProjectName));
            driver.findElement(dpdProjectName).click();
        }
        
        driver.findElement(txtActivity).click();
        Thread.sleep(2000);
        //wait.until(ExpectedConditions.elementToBeClickable(dpdActivity));
        driver.findElement(dpdActivity).click();

        WebElement time1 = driver.findElement(txttime1);
        time1.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        time1.sendKeys(monday);
        
        WebElement time2 = driver.findElement(txttime2);
        //wait.until(ExpectedConditions.elementToBeClickable(time2));
        time2.click();
        time2.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        time2.sendKeys(tuesday);
        
        WebElement time3 = driver.findElement(txttime3);
        time3.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        time3.sendKeys(wednesday);
    
        WebElement time4 = driver.findElement(txttime4);
        time4.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        time4.sendKeys(thursday);

        WebElement time5 = driver.findElement(txttime5);
        time5.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        time5.sendKeys(friday);
        
        WebElement time6 = driver.findElement(txttime6);
        time6.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        time6.sendKeys(saturday);

        
        WebElement time7 = driver.findElement(txttime7);
        time7.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        time7.sendKeys(sunday);

        //wait.until(ExpectedConditions.elementToBeClickable(btnSave));
        driver.findElement(btnSave).click();

    }

    public String msgSuccessDisplay() throws InterruptedException {
        //WebElement msgSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(messageSuccess));
        WebElement msgSuccess = driver.findElement(messageSuccess);
        Thread.sleep(1500);
        System.out.println(msgSuccess.getText());
         return msgSuccess.getText();
        
    }

    public String getProject(){
         return driver.findElement(project).getText();
    }

    public String getActivity(){
        return driver.findElement(activity).getText();
    }

    public String getMon(){
        return driver.findElement(Mon).getText();
    }

    public String getTue(){
        return driver.findElement(Tue).getText();
    }

    public String getWed(){
        return driver.findElement(Wed).getText();
    }

    public String getThu(){
        return driver.findElement(Thu).getText();
    }

    public String getFri(){
        return driver.findElement(Fri).getText();
    }

    public String getSat(){
        return driver.findElement(Sat).getText();
    }

    public String getSun(){
        return driver.findElement(Sun).getText();
    }
    
}
