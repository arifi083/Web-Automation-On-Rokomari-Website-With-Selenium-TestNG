package testcases;

import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;

public class NavbarTest extends BaseClass {
     LoginPage loginPage;
     HomePage homePage;
     NavbarPage navbarPage;
     ProductPage productPage;

    BookDetailsPage bookDetailsPage;


    public NavbarTest() throws IOException {
        super();
    }
    @BeforeMethod
    public void initialization() throws IOException, InterruptedException {
        setUp();
        homePage=new LoginPage()
                .login(getUserName(),getPassword());
        navbarPage = new NavbarPage();
    }

    //Write testcases
    @Test
    public void clicckNavbar() throws InterruptedException, IOException {
        productPage = NavbarPage.goToProduct();
        productPage.writerNameHeading();
       // productPage.sortingAndFiltering();
        //bookDetailsPage = productPage.clickbookDetails();



    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
