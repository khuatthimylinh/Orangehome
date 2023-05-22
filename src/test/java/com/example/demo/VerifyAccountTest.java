package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.testng.Assert;

import com.page.OrangeHomePage;

@SpringBootApplication
public class VerifyAccountTest extends LoginTest{

	OrangeHomePage orangeHome;
	
	@Test
	public void verifyAccount() {		
		orangeHome = new OrangeHomePage();
		orangeHome.login("Admin","admin123");
		orangeHome.getAccount();
		Assert.assertTrue(orangeHome.isUsernameDisplay());
	}

}
