package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.page.OrangeHome;



public class Login extends OrangeHome{
	OrangeHome orangeHome;
	public WebDriver driver;
	@Test
	public void Loginpage() {
		orangeHome = new OrangeHome();
		orangeHome.openUrl();
		orangeHome.login("Admin","admin123");
	}
	

}
