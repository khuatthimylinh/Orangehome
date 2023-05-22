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
public class NavigateAdminpageTest{
	OrangeHomePage orangeHome;

	@Test
	public void navigateAdminpage() {
		
		orangeHome = new OrangeHomePage();
		orangeHome.Navigate();
		Assert.assertTrue(orangeHome.isAdminpageDisplay());
	}

}
