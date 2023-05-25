package com.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigateAdminPage extends BaseTest{
    private By lbAdmin = (By.xpath("//span[text()='Admin']"));

    public void Navigate(){  

		driver.findElement(lbAdmin).click();
        explicitWaitForVisible(10,lbAdmin);
        
    }
}
