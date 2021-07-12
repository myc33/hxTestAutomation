package Pages;

import gherkin.lexer.Th;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    final static Logger logger = Logger.getLogger(BasketPage.class);

    public void goToBasket() throws Exception {

        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[contains(.,'Cart')]")));
            driver.findElement(By.xpath("//b[contains(.,'Cart')]")).click();
        } catch (InterruptedException e) {
            takeSnapShot(driver, "/Users/mycelik/Desktop//goToBasketPageFail.png");
            logger.info("Go to basket page fail.");
            Assert.fail();
        }

    }

    public void checkproductPrice() throws Exception {
        String basketPrice;
        try {
            basketPrice = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[1]/td[4]/span/span[1]")).getText();
            Assert.assertEquals(ProductPage.productPrice, basketPrice);
            basketPrice = driver.findElement(By.xpath("  /html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[2]/td[4]/span/span[1]")).getText();
            Assert.assertEquals(ProductPage.productPrice, basketPrice);
        } catch (Exception e) {
            takeSnapShot(driver, "/Users/mycelik/Desktop//checkProductPriceFail.png");
            logger.info("Check product price fail.");
            Assert.fail();
        }

    }

    public void checkQuantity() throws Exception {
        String basketQuantity;
        try {
            basketQuantity = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[1]/td[5]/input[2]")).getText();
            Assert.assertEquals(ProductPage.quantity, basketQuantity);
            basketQuantity = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[2]/td[5]/input[2]")).getText();
            Assert.assertEquals(ProductPage.quantity, basketQuantity);
        } catch (Exception e) {
            takeSnapShot(driver, "/Users/mycelik/Desktop//checkQuantitytPriceFail.png");
            logger.info("Check quantity price fail.");
            Assert.fail();
        }

    }

    public void goToSelectAdress() throws Exception {

        try {
            driver.findElement(By.xpath("//div[@id='center_column']/p[2]/a/span")).click();
        } catch (Exception e) {
            takeSnapShot(driver, "/Users/mycelik/Desktop//goToSelectAddressFail.png");
            logger.info("Go to select address page fail.");
            Assert.fail();
        }

    }
}
