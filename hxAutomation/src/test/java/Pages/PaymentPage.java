package Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    final static Logger logger = Logger.getLogger(PaymentPage.class);

    public void selectPaymentType() throws Exception {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='HOOK_PAYMENT']/div/div/p/a/span")));
            driver.findElement(By.xpath("//div[@id='HOOK_PAYMENT']/div/div/p/a/span")).click();
        } catch (Exception e) {
            takeSnapShot(driver, "/Users/mycelik/Desktop//selectPaymentTypeFail.png");
            logger.info("Select payment type fail.");
            Assert.fail();
        }

    }

    public void completeOrder() throws Exception {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@id='cart_navigation']/button/span")));
            driver.findElement(By.xpath("//p[@id='cart_navigation']/button/span")).click();
        } catch (Exception e) {
            takeSnapShot(driver, "/Users/mycelik/Desktop//sompleteOrderFail.png");
            logger.info("Complete order fail.");
            Assert.fail();
        }

    }

    public void goToOrders() throws Exception {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Back to orders')]")));
            driver.findElement(By.xpath("//a[contains(text(),'Back to orders')]")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            takeSnapShot(driver, "/Users/mycelik/Desktop//goTOOrderFail.png");
            logger.info("Go to order page fail.");
            Assert.fail();
        }

    }
}
