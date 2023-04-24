package pageobjects;

import baseclass.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.io.IOException;
import java.time.Duration;

public class LoginPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static final WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
    public LoginPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }


    @FindBy(id="j_username")
    WebElement username;

    @FindBy(id="j_password")
    WebElement password;

    @FindBy(css="#js--message > p")
    WebElement invalidMsgVerify;

    @FindBy(xpath = "//form[@id='loginForm']//button[@type='submit']")
    WebElement signInButton;

    public HomePage login(String uname, String pass) throws IOException, InterruptedException {
        username.sendKeys(uname);
        password.sendKeys(pass);

          this.scroll();

        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        return new HomePage();
    }


    public LoginPage invalidLogin(String uname, String pass) throws InterruptedException {
        username.sendKeys(uname);
        password.sendKeys(pass);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", signInButton);
        Thread.sleep(2000);
        return this;

    }

    public void scroll() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,200)");
        Thread.sleep(1200);
    }


    public String verifyCreds(){
        System.out.println("arif");
        //driver.getPageSource();
       String msg =invalidMsgVerify.getText();
        System.out.println(msg);
       return msg;
    }




}
