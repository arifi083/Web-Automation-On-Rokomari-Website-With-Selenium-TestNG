package pageobjects;

import baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class BookDetailsPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static final WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
    public BookDetailsPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }

    @FindBy(css="div.details-book-main-info__header > h1")
    WebElement bookName;

    @FindBy(css ="#js--details-btn-area>:nth-child(2)")
    WebElement addToCart;

    @FindBy(css="#js--feature-popup > div.feature-popup__header > button")
    WebElement closeTab;

    @FindBy(css="#js--details-btn-area>:nth-child(2)")
    WebElement goToCart;

    @FindBy(css="div.details-book-main-info__content > p > a")
    WebElement writerName;



    public boolean verifyBookName(){
        return bookName.isDisplayed();
    }

    public String getBookDetailsWriterName(){
      String  bookWriterName = writerName.getText();
      return bookWriterName;
    }
    public AddToCartPage clickAddToCart() throws InterruptedException, IOException {
        this.scroll();
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        addToCart.click();
        Thread.sleep(4000);
        wait.until(ExpectedConditions.elementToBeClickable(closeTab));
        closeTab.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(goToCart));
        goToCart.click();
        return new AddToCartPage();

    }

    public AddToCartPage clickAGoToCart() throws InterruptedException, IOException {
        this.scroll();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(goToCart));
        goToCart.click();
        return new AddToCartPage();

    }

    public void scroll() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,150)");
        Thread.sleep(1200);
    }


}
