package com.orange.hrm.test;

import com.utility.ExtentReportUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    @BeforeSuite
    public void setUpExtentReport(){
        ExtentReportUtility.setUpReport();
    }

    @BeforeMethod
    public void createExtentTest(Method method) {
        ExtentReportUtility.createTest(method.getName());
    }

    @BeforeMethod
    public void initDriver() throws InterruptedException {
        //ExtentReportUtility.setUpReport();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(6000);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

    @AfterSuite
    public void tearDownExtentReport(){
        ExtentReportUtility.flushReport();
    }

}
