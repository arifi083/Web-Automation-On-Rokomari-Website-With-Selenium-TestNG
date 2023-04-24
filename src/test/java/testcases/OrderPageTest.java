package testcases;

import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

import java.io.IOException;

public class OrderPageTest extends BaseClass {
    HomePage homePage;
    NavbarPage navbarPage;
    ProductPage productPage;

    BookDetailsPage bookDetailsPage;

    AddToCartPage addToCartPage;
    OrderPage orderPage;
    public OrderPageTest() throws IOException {
        super();
    }
    @BeforeMethod
    public void initialization() throws IOException, InterruptedException {
        setUp();
        homePage=new LoginPage()
                .login(getUserName(),getPassword());
        orderPage = new OrderPage();

    }
    @Test
    public void confirmOrderTest() throws IOException, InterruptedException {
        productPage = NavbarPage.goToProduct();
        productPage.writerNameHeading();
        productPage.sortingAndFiltering();

        bookDetailsPage = productPage.clickbookDetails();
        bookDetailsPage.verifyBookName();
        String bookDetailWriterName = bookDetailsPage.getBookDetailsWriterName();

        //addToCartPage = bookDetailsPage.clickAddToCart();
        addToCartPage = bookDetailsPage.clickAGoToCart();
        String writerNameCartPage = addToCartPage.addToCartPageWriterName();
        Assert.assertEquals(bookDetailWriterName,writerNameCartPage);
        String cartPageBalence = addToCartPage.addToCartTK();
       // System.out.println(cartPageBalence);

        orderPage = addToCartPage.clickPlaceOrder();
        String subTotalBalence = orderPage.getSubTotal();
       // System.out.println(subTotalBalence);
        Assert.assertEquals(cartPageBalence,subTotalBalence);
        orderPage.confirmOrder();
        orderPage.setAddress(getAddress());
        orderPage.setPayment();





    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
