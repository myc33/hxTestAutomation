package Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage extends BasePage {
    public AddressPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    final static Logger logger = Logger.getLogger(AddressPage.class);

    public void goToSelectShipping() throws Exception {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='center_column']/form/p/button/span")));
            driver.findElement(By.xpath("//div[@id='center_column']/form/p/button/span")).click();
        } catch (Exception e) {
            takeSnapShot(driver, "/Users/mycelik/Desktop//goToShippingFail.png");
            logger.info("Go to shipping page fail.");
            Assert.fail();
        }


    }
}
