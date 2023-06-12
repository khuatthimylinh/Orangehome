package common;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.example.demo.OpenBrowserTest;

import java.util.concurrent.TimeUnit;

//import static java.time.Duration.*;


public class BaseTest {
    protected static WebDriver driver;
    public String chromePath = "D:\\project\\chromedriver_win32\\chromedriver.exe";
    public String Url = "https://opensource-demo.orangehrmlive.com/";


    public void openUrl() {
//        SpringApplication.run(OpenBrowserTest.class);
        System.setProperty("webdriver.chrome.driver", chromePath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(Url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public void openBrowser(String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        } else {
            System.out.println("Please provide a valid browser name!");
        }

        driver.manage().window().maximize();
        driver.get(Url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void tearDown(WebDriver driver) {
        driver.close();
        driver.quit();
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
