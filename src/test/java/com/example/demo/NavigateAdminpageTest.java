package com.example.demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.data.param;
import com.page.BaseTest;
import com.page.LoginPage;
import com.page.NavigateAdminPage;

@SpringBootApplication
public class NavigateAdminpageTest extends BaseTest{
	LoginPage login;
	NavigateAdminPage navigateAdmin;
	private String url_Admin = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";

	@Test(dataProvider = "account", dataProviderClass = param.class)
	public void navigateAdminpage(String username, String password){
		login = new LoginPage();
		login.login(username,password);

		navigateAdmin = new NavigateAdminPage();
		navigateAdmin.Navigate();
		Assert.assertEquals(driver.getCurrentUrl(), url_Admin);
	}

	@AfterTest
	public void tearDown(){
		super.tearDown(driver);
	}
}

