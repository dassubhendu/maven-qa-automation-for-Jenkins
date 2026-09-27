package com.orange.hrm.test;

import com.orange.hrm.pages.HomePage;
import com.orange.hrm.pages.LoginPage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @Test
    public void logout(){
        LoginPage loginPage= new LoginPage();
        HomePage homePage = new HomePage();
        loginPage.loginApplication("Admin", "admin123");
        homePage.clickOnAdminLink();
        homePage.logoutFromApplication();
    }

}
