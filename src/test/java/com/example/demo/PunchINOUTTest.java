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

import com.example.data.param;
import com.page.LoginPage;
import com.page.PunchINOutPage;
import com.page.TimesheetPage;

import common.BaseTest;


public class PunchINOUTTest extends BaseTest{
	LoginPage login;
	PunchINOutPage punchInOut;
	private String ExpectedMsg = "Successfully Saved";
	private String ExpectedPunchIn = "2023-06-12 05:45 PM GMT +07:00";
	private String ExpectedPunchOut = "2023-06-12 06:00 PM GMT +07:00";
	
	@Test(dataProvider = "dataTimeInOut", dataProviderClass = param.class)
	public void punchInOutTest(String timeIn, String timeOut) throws InterruptedException{
//		login = new LoginPage();
//		login.login(username,password);

		punchInOut = new PunchINOutPage();
		punchInOut.UpdatePunchIn(timeIn);
		Assert.assertEquals(punchInOut.msgSuccessDisplay(), ExpectedMsg);

		Thread.sleep(8000);
		
		punchInOut.UpdatePunchOut(timeOut);
		Assert.assertEquals(punchInOut.msgSuccessDisplay(), ExpectedMsg);

		punchInOut.checkoutMyrecord();
		Assert.assertEquals(punchInOut.getPunchIn(), ExpectedPunchIn);
		Assert.assertEquals(punchInOut.getPunchOut(), ExpectedPunchOut);
	}

	@AfterTest
	public void tearDown(){
		super.tearDown(driver);
	}

}
