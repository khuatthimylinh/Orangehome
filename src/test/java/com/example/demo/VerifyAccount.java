package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.page.OrangeHome;

@SpringBootApplication
public class VerifyAccount extends Login{

	OrangeHome orangeHome;
	public WebDriver driver;
	@Test
	public void verifyAccount() {
			
		orangeHome = new OrangeHome();
		orangeHome.openUrl();
		orangeHome.login("Admin","admin123");
		orangeHome.getText();	
	}

}
