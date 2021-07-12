package Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage extends BasePage {
    public ShippingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    final static Logger logger = Logger.getLogger(ShippingPage.class);

    public void checkCheckBoxAndGoToPayment() throws Exception {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(.,'I agree to the terms of service and will adhere to them unconditionally.')]")));
            driver.findElement(By.xpath("//label[contains(.,'I agree to the terms of service and will adhere to them unconditionally.')]")).click();
            driver.findElement(By.xpath("//form[@id='form']/p/button/span")).click();
        } catch (Exception e) {
            takeSnapShot(driver, "/Users/mycelik/Desktop//shippingPageFail.png");
            logger.info("Shipping page fail.");
            Assert.fail();
        }

    }

}
