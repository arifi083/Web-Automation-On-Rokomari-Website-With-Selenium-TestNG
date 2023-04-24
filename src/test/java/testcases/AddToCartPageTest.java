package testcases;

import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;

public class AddToCartPageTest extends BaseClass {
    HomePage homePage;
    NavbarPage navbarPage;
    ProductPage productPage;

    BookDetailsPage bookDetailsPage;

    AddToCartPage addToCartPage;
    OrderPage orderPage;
    public AddToCartPageTest() throws IOException {
        super();
    }
    @BeforeMethod
    public void initialization() throws IOException, InterruptedException {
        setUp();
        homePage=new LoginPage()
                .login(getUserName(),getPassword());
        //addToCartPage = new AddToCartPage();

    }
    @Test
    public void addToCartTest() throws IOException, InterruptedException {
        productPage = NavbarPage.goToProduct();
        productPage.writerNameHeading();
        productPage.sortingAndFiltering();
        bookDetailsPage = productPage.clickbookDetails();
        bookDetailsPage.verifyBookName();
       String bookDetailWriterName = bookDetailsPage.getBookDetailsWriterName();
        addToCartPage = bookDetailsPage.clickAddToCart();
        String writerNameCartPage = addToCartPage.addToCartPageWriterName();
        Assert.assertEquals(bookDetailWriterName,writerNameCartPage);
       // orderPage = addToCartPage.clickPlaceOrder();


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
