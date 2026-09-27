package com.orange.hrm.test;

import com.orange.hrm.pages.HomePage;
import com.orange.hrm.pages.LoginPage;
import com.utility.ExcelUtility;
import com.utility.PropertiesUtility;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class LoginTest extends BaseTest{

    @Test
    public void loginWithValidCredential() throws IOException, InvalidFormatException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        //loginPage.loginApplication("Admin", "admin123");
        loginPage.loginApplication(ExcelUtility.getTestDataFromExcel(1,0), ExcelUtility.getTestDataFromExcel(1,1));
        Thread.sleep(4000);
    }

    @Test(enabled = true)
    public void loginWithValidCredentialExcelDriven()
            throws IOException, InvalidFormatException, InterruptedException {

        File file = new File("./src/testData/testData.xlsx");

        XSSFWorkbook book = new XSSFWorkbook(file);
        Sheet sheet = book.getSheet("LoginData");

        int lastRow = sheet.getLastRowNum();

        System.out.println("Last row index: " + lastRow);

        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        // Start from row 1 because row 0 contains the headers
        for (int i = 1; i <= lastRow; i++) {

            String username = sheet.getRow(i).getCell(0).getStringCellValue();
            String password = sheet.getRow(i).getCell(1).getStringCellValue();

            System.out.println("Username: " + username);
            System.out.println("Password: " + password);

            loginPage.loginApplication(username, password);
            Thread.sleep(3000);

            if(driver.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")){
                homePage.clickOnAdminLink();
                homePage.logoutFromApplication();
            }


        }

        book.close();
    }


    @Test
    public void loginWithValidCredentialUsingPropertiesFile() throws IOException, InvalidFormatException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.loginApplication(PropertiesUtility.getData("username"), PropertiesUtility.getData("password"));
        Thread.sleep(4000);
    }


}
