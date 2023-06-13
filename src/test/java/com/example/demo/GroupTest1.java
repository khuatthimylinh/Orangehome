package com.example.demo;

import com.example.data.param;
import com.page.LoginPage;
import com.page.NavigateAdminPage;
import com.page.VerifyAccountPage;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test(groups = "group-1")
public class GroupTest1 extends BaseTest {

    LoginPage login;
    VerifyAccountPage getaccount;
    NavigateAdminPage navigateAdmin;
    private String url_Admin = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";

    @BeforeTest
    public void open(){
        super.openUrl();
    }

    @Test(priority = 1, groups = "test1",dataProvider = "data", dataProviderClass = param.class)
    public void loginTest(String username, String password) {
        login = new LoginPage();
        login.login(username,password);
        Assert.assertTrue(login.isLogoDisplay());

    }
    @Test(priority = 2, groups = "test1")
    public void verifyAccount() {

        getaccount = new VerifyAccountPage();
        getaccount.getAccount();

    }

    @Test(priority = 3, groups = "test1")
    public void navigateAdminpage(){

        navigateAdmin = new NavigateAdminPage();
        navigateAdmin.Navigate();
        Assert.assertEquals(driver.getCurrentUrl(), url_Admin);
    }
    @AfterTest
	public void tearDown(){
		super.tearDown(driver);
	}
    
}
