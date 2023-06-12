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
import com.page.TimesheetPage;

import common.BaseTest;

public class EditTimesheetSuccessTest extends BaseTest{
	LoginPage login;
	TimesheetPage timesheet;
	private String expectedText = "Successfully Saved";
	private String expectedProject = "The Coca-Cola Company - Coke - Phase 1";
	private String expectedActivity ="Administration";
	private String expectedMon ="01:00";
	private String expectedTue ="02:00";
	private String expectedWed ="03:00";
	private String expectedThu ="04:00";
	private String expectedFri ="05:00";
	private String expectedSat ="06:00";
	private String expectedSun ="07:00";
	
	@Test(dataProvider = "dataTimesheet", dataProviderClass = param.class)
	public void editTimesheetSuccessTest(String username, String password, String project, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday ) throws InterruptedException{

		openUrl();
		login = new LoginPage();
		login.login(username,password);

		timesheet = new TimesheetPage();
		timesheet.EditMyTimesheet(project,monday,tuesday,wednesday,thursday,friday,saturday,sunday);
	
		Assert.assertEquals(timesheet.msgSuccessDisplay(), expectedText);
		Assert.assertEquals(timesheet.getProject(), expectedProject);
		Assert.assertEquals(timesheet.getActivity(), expectedActivity);
		Assert.assertEquals(timesheet.getMon(), expectedMon);
		Assert.assertEquals(timesheet.getTue(), expectedTue);
		Assert.assertEquals(timesheet.getWed(), expectedWed);
		Assert.assertEquals(timesheet.getThu(), expectedThu);
		Assert.assertEquals(timesheet.getFri(), expectedFri);
		Assert.assertEquals(timesheet.getSat(), expectedSat);
		Assert.assertEquals(timesheet.getSun(), expectedSun);
	}

//	@AfterTest
//	public void tearDown(){
//		super.tearDown(driver);
//	}

}
