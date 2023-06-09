package com.example.demo;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.data.param;
import com.page.LoginPage;

import common.BaseTest;



public class LoginTest extends BaseTest{
	LoginPage login;

	@Test(dataProvider = "data", dataProviderClass = param.class)
	public void loginTest(String username, String password) {

		login = new LoginPage();
		login.login(username,password);
		Assert.assertTrue(login.isLogoDisplay());

	}
	
//	@AfterTest
//	public void tearDown(){
//		super.tearDown(driver);
//	}

}
