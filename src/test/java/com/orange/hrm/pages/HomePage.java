package com.orange.hrm.pages;

import com.orange.hrm.test.BaseTest;
import com.utility.ExtentReportUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

    @FindBy(xpath = "//span[text()='Admin']")
    WebElement adminLink;

    @FindBy(xpath = "//img[@alt='profile picture']")
    WebElement profilePic;

    @FindBy(linkText = "Logout")
    WebElement logoutLink;

    public HomePage(){
        PageFactory.initElements(BaseTest.driver, this);
    }

    public void clickOnAdminLink(){
        adminLink.click();
    }

    public void logoutFromApplication(){
        profilePic.click();
        ExtentReportUtility.addStep("Profile picture image is clicked");
        logoutLink.click();
        ExtentReportUtility.addStep("Logout link is clicked");
    }

}
