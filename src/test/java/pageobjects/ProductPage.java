package pageobjects;

import baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class ProductPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static final WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
    public ProductPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }

    @FindBy(css=" div.browse__content--heading > div > div > h1")
    WebElement writerHeading;

    @FindBy(css="label[for='SOLD_COUNT_DESC']")
    WebElement bsetSelling;

    @FindBy(css="label[for='rok-filter-categoryIds-677']")
    WebElement recentNovel;

    @FindBy(css="label[for='rok-filter-categoryIds-716']")
    WebElement wholeNovelFiltering;


    @FindBy(css="div.browse__content-books-wrapper > div> div:nth-child(2)>div")
    WebElement bookDetailsDiv;

    @FindBy(css="div.browse__content-books-wrapper > div > div:nth-child(2) > div > div>a")
    WebElement bookDetails;





    public boolean writerNameHeading(){
        return  writerHeading.isDisplayed();
    }


    public void sortingAndFiltering() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(bsetSelling));
        bsetSelling.click();
        this.scroll();
        wait.until(ExpectedConditions.elementToBeClickable(recentNovel));
        recentNovel.click();
        this.scroll();
        wait.until(ExpectedConditions.elementToBeClickable(wholeNovelFiltering));
        wholeNovelFiltering.click();
        this.scroll();
        Thread.sleep(3000);

    }


    public BookDetailsPage clickbookDetails() throws InterruptedException, IOException {
        Actions action = new Actions(driver);
        action.moveToElement(bookDetailsDiv).build().perform();

        action.moveToElement(bookDetails);
        action.click().build().perform();
        Thread.sleep(2000);
        return new BookDetailsPage();

    }

    public void scroll() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,385)");
        Thread.sleep(1200);
    }



}
