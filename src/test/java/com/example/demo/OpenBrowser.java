package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.testng.annotations.Test;

import com.page.OrangeHome;

@SpringBootApplication
public class OpenBrowser{
	OrangeHome orangeHome;
	public WebDriver driver;
	@Test
	public void Open() {
		// SpringApplication.run(OpenBrowser.class);
		// System.setProperty("webdriver.chrome.driver","D:\\project\\chromedriver_win32\\chromedriver.exe");

		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--remote-allow-origins=*");

		// WebDriver driver = new ChromeDriver(options);
		// String baseUrl = "https://opensource-demo.orangehrmlive.com";
		// driver.get(baseUrl);

		orangeHome = new OrangeHome();
		orangeHome.openUrl();
		
	}

}
