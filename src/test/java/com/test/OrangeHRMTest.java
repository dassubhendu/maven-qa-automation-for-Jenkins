package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHRMTest {

    ChromeDriver driver;

    @BeforeMethod
    public void browserLaunch() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void verifySuccessfulLogin() throws InterruptedException {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(5000);
        boolean isDashboardBtnDisplayedStatus = driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed();
        Assert.assertTrue(isDashboardBtnDisplayedStatus);

    }

    @Test(priority = 1)
    public void verifyUnsuccessfulLogin() throws InterruptedException {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin123");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin345");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(5000);

        String actualHomePageURL = driver.getCurrentUrl();
        String expectedHomePageURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Assert.assertEquals(actualHomePageURL, expectedHomePageURL);

    }

    @Test(priority = 2)
    public void verifySuccessfulLogout() throws InterruptedException {
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(5000);

        WebElement profileICon = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i"));
        profileICon.click();

        WebElement logoutBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a"));
        logoutBtn.click();
        Thread.sleep(5000);

    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

}
