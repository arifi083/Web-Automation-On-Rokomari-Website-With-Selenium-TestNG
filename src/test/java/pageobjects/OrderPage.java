package pageobjects;

import baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class OrderPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static final WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
    public OrderPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//*[@id=\"subtotal\"]")
    WebElement subTotal;

    @FindBy(xpath = "//select[@id='js--city']")
    WebElement city;

    @FindBy(xpath = "//select[@id='js--area']")
    WebElement area;

    @FindBy(id= "address")
    WebElement customerAddress;

    @FindBy(css="label[for='cod']")
    WebElement cod;



    public String getSubTotal(){
        String subTotalTk = subTotal.getText();
        String subTotalValue = subTotalTk.substring(0,3);
        return subTotalValue;
    }



    public void confirmOrder() throws InterruptedException {
        Thread.sleep(3000);
        Select cityValue = new Select(city);
        cityValue.selectByValue("2");
        Thread.sleep(4000);


        wait.until(ExpectedConditions.elementToBeClickable(area));
        Select areaValue = new Select(area);
        areaValue.selectByValue("110");
        Thread.sleep(3000);
    }

    public void setAddress(String address){
        customerAddress.sendKeys(address);
    }

    public void setPayment() throws InterruptedException {
        this.scroll();
        cod.click();
        Thread.sleep(2000);
        this.scroll();
    }

    public void scroll() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,290)");
        Thread.sleep(1500);
    }








}
