package testcases;

import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.HomePage;
import pageobjects.IndexPage;
import pageobjects.LoginPage;
import utilities.TimeOut;

import java.io.IOException;

public class LoginPageTest extends BaseClass {
    public HomePage homePage;
    public LoginPage loginPage;
    public LoginPageTest() throws IOException {
        super();

    }

    @BeforeMethod
    public void initialization() throws IOException {
        setUp();
        loginPage=new LoginPage();
    }
  @Test(priority = 2)
   public void loginWithValidCredentials() throws IOException, InterruptedException {
       homePage = loginPage.login(getUserName(),getPassword());
       homePage.homePageText();
   }


    @Test(dataProvider = "GetExcelData-DataProvider")
    public void loginWithInValidCredentials(String userName, String password) throws IOException, InterruptedException {

        loginPage= loginPage
                .invalidLogin(userName,password);
        String invalidMsg = loginPage.verifyCreds();
        System.out.println(invalidMsg);
        Assert.assertTrue(invalidMsg.contains("Please check your email/phone and verify your account first. Verify account?"));

    }

    @DataProvider(name="GetExcelData-DataProvider")
    public Object[][] getDataProviderDataFromExcel(){
        return TimeOut.getTestData("Sheet1");

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



}
