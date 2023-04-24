package testcases;

import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.IndexPage;

import java.io.IOException;

public class IndexPageTest extends BaseClass {

    public IndexPage indexPage;
    public IndexPageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void initialization() throws IOException {
        setUp();
    }

  @Test
    public void verifyLogo() throws IOException {
      indexPage = new IndexPage();
     boolean result = indexPage.validateLogo();
      Assert.assertTrue(result);
    }

    @Test
    public void verifyTitle() throws IOException {
        indexPage = new IndexPage();
       String getTitle = indexPage.verifyTitle();
       Assert.assertEquals(getTitle,"Login To Rokomari | Rokomari.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
