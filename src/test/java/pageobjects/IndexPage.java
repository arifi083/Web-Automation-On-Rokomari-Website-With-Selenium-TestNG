package pageobjects;

import baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class IndexPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static final WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

    @FindBy(css="body > header > div > div > div > div > div.col-2 > div > a > img")
    WebElement rokomariLogo;

    @FindBy(css=" div.dropdown.user-menu > a")
    WebElement signBtn;


    public IndexPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }

    public boolean validateLogo(){
       return rokomariLogo.isDisplayed();
    }

    public String verifyTitle(){
        String rokomarititle = driver.getTitle();
        System.out.println(rokomarititle);
        return rokomarititle;
    }

    public LoginPage clickSignIn() throws IOException {
       signBtn.click();
       return new LoginPage();
    }
}
