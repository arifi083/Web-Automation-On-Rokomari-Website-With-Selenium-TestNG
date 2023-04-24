package testcases;

import baseclass.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;

public class ProductPageTest extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
    NavbarPage navbarPage;
    ProductPage productPage;

    BookDetailsPage bookDetailsPage;

    AddToCartPage addToCartPage;


    public ProductPageTest() throws IOException {
        super();
    }
    @BeforeMethod
    public void initialization() throws IOException, InterruptedException {
        setUp();
        homePage=new LoginPage()
                .login(getUserName(),getPassword());
        productPage = new ProductPage();
    }

    //Write testcases
    @Test
    public void clickProductDetails() throws InterruptedException, IOException {
        productPage = NavbarPage.goToProduct();
        productPage.writerNameHeading();
        productPage.sortingAndFiltering();
        bookDetailsPage = productPage.clickbookDetails();
        bookDetailsPage.verifyBookName();
        //addToCartPage = bookDetailsPage.clickAddToCart();



    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
