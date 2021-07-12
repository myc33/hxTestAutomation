package Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    final static Logger logger = Logger.getLogger(ProductPage.class);

    public static String productPrice;
    public static String quantity;
    public static String productName;

    public void goToSummerDress() throws Exception {
        try {
            driver.findElement(By.xpath("(//a[contains(text(),'Dresses')])[5]")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'Summer Dresses')])[3]")));
            driver.findElement(By.xpath("(//a[contains(text(),'Summer Dresses')])[3]")).click();
        } catch (Exception e) {
            takeSnapShot(driver, "/Users/mycelik/Desktop//goToSummerDressFail.png");
            logger.info("Go to summer dress fail.");
            Assert.fail();
        }


    }

    public void searchProduct(String searchValue) throws Exception {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("search_query_top")));
            driver.findElement(By.id("search_query_top")).sendKeys(searchValue);
            driver.findElement(By.name("submit_search")).click();
        } catch (Exception e) {
            takeSnapShot(driver, "/Users/mycelik/Desktop//searchProductFail.png");
            logger.info("Search product fail.");
            Assert.fail();
        }
    }

    public void addCart(String colorId) throws Exception {

        try {
            downScroll();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")));
            productName = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")).getText();
            driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("color_" + colorId + "")));
            WebElement color = driver.findElement(By.id("color_" + colorId + ""));
            Actions action = new Actions(driver);
            action.moveToElement(color).click().build().perform();
            Thread.sleep(2000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Add to cart')]")));
            productPrice = driver.findElement(By.id("our_price_display")).getText();
            quantity = driver.findElement(By.id("quantity_wanted")).getText();
            driver.findElement(By.xpath("//span[contains(.,'Add to cart')]")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='layer_cart']/div/div[2]/div[4]/span/span")));
            driver.findElement(By.xpath("//div[@id='layer_cart']/div/div[2]/div[4]/span/span")).click();
        } catch (InterruptedException e) {
            takeSnapShot(driver, "/Users/mycelik/Desktop//addProductFail.png");
            logger.info("Add product on cart fail.");
            Assert.fail();
        }


    }
}
