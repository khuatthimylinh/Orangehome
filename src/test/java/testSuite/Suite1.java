package testSuite;

// import org.mockito.internal.exceptions.Reporter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.example.data.param;
import com.page.LoginPage;
import com.page.NavigateAdminPage;
import com.page.VerifyAccountPage;

import common.BaseTest;

public class Suite1 extends BaseTest{
    BaseTest baseTest;
    LoginPage login;
    VerifyAccountPage getaccount;
    NavigateAdminPage navigateAdmin;
	private String url_Admin = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";

	//private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeTest
	public void beforeTest() {
		super.openUrl();
	}


    @Test(dataProvider = "data", dataProviderClass = param.class)
	public void loginTest(String username, String password) {

		login = new LoginPage();
		login.login(username,password);
		Assert.assertTrue(login.isLogoDisplay());
	}
    @Test()
	public void verifyAccount() {

		getaccount = new VerifyAccountPage();
		getaccount.getAccount();

	}
    @Test()
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

