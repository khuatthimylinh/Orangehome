package com.page;

import org.openqa.selenium.By;

import common.BaseTest;

public class VerifyAccountPage extends BaseTest{
    private By name = By.xpath("//p[@class='oxd-userdropdown-name']");

    public void getAccount(){

		String getName = driver.findElement(name).getText();
        System.out.println(getName);
        
    }
}
