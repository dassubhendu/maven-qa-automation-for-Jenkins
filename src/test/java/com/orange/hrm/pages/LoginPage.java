package com.orange.hrm.pages;

import com.orange.hrm.test.BaseTest;
import com.utility.ExtentReportUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name = "username")
    WebElement userNameTextBox;

    @FindBy(name = "password")
    WebElement passwordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    public LoginPage(){
        PageFactory.initElements(BaseTest.driver, this);
    }

    public void loginApplication(String username, String password){
        userNameTextBox.clear();
        ExtentReportUtility.addStep("Username text box has been cleared");
        userNameTextBox.sendKeys(username);
        ExtentReportUtility.addStep("Username has been entered");
        passwordTextBox.clear();
        ExtentReportUtility.addStep("Password text box has been cleared");
        passwordTextBox.sendKeys(password);
        ExtentReportUtility.addStep("Password has been entered");
        loginBtn.click();
        ExtentReportUtility.addStep("Login button has been clicked");
    }

}
