package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.OrangeHomePage;

@SpringBootApplication
public class OpenBrowserTest{
	OrangeHomePage orangeHome;

	@Test
	public void Open() {
		orangeHome = new OrangeHomePage();
		orangeHome.openUrl();
		Assert.assertTrue(orangeHome.isloginDisplay());
	}

}
