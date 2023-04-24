package pageobjects;

import baseclass.BaseClass;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class AddToCartPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static final WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
    public AddToCartPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }

    @FindBy(css="div.book-info__content--book-meta > p")
    WebElement cartWriterName;

    @FindBy(id="btn-plus")
    WebElement cartPlusBtn;

    @FindBy(id="btn-minus")
    WebElement cartMinusBtn;

    @FindBy(xpath ="//a[@id='js-continue-to-shipping']")
    WebElement placeOrderBtn;

    @FindBy(css ="div.book-info__content--price > div > p.js--prc.text-right")
    WebElement cartTk;

    public String addToCartPageWriterName(){
        String cartWriterNameText = cartWriterName.getText();
        return  cartWriterNameText;
    }

    public String addToCartTK(){
        String cartBalence = cartTk.getText();
        String accurateBalence = cartBalence.substring(4,7);
        return accurateBalence;
    }

    public OrderPage clickPlaceOrder() throws InterruptedException, IOException {
        wait.until(ExpectedConditions.elementToBeClickable(cartPlusBtn));
        cartPlusBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(cartMinusBtn));
        cartMinusBtn.click();
        placeOrderBtn.click();
        return new OrderPage();
    }


}
