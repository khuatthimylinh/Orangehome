package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import common.BaseTest;



public class OpenBrowserTest extends BaseTest{
	BaseTest baseTest;
	private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@Test
	public void Open() {
		baseTest = new BaseTest();
		baseTest.openUrl();
		Assert.assertEquals(driver.getCurrentUrl(),url);

	}
	
	@AfterTest
	public void tearDown(){
		super.tearDown(driver);
	}
}
