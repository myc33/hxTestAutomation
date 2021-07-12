package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    final static Logger logger = Logger.getLogger(RegisterPage.class);

    public void register() throws Exception {
        try {
            driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
            driver.findElement(By.id("email_create")).sendKeys("myc10@hotmail.com");
            driver.findElement(By.id("SubmitCreate")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
            driver.findElement(By.id("id_gender1")).click();
            driver.findElement(By.id("customer_firstname")).sendKeys("myc");
            driver.findElement(By.id("customer_lastname")).sendKeys("celik");
            driver.findElement(By.id("passwd")).sendKeys("123456");
            Select days = new Select(driver.findElement(By.id("days")));
            days.selectByValue("25");
            Select months = new Select(driver.findElement(By.id("months")));
            months.selectByValue("10");
            Select years = new Select(driver.findElement(By.id("years")));
            years.selectByValue("1995");
            driver.findElement(By.id("firstname")).sendKeys("myc");
            driver.findElement(By.id("lastname")).sendKeys("celik");
            driver.findElement(By.id("company")).sendKeys("hepsiexpress");
            driver.findElement(By.id("address1")).sendKeys("dsakfhajkfahkjfajkfjjkaf safkakhfa");
            driver.findElement(By.id("city")).sendKeys("Istanbul");
            downScroll();
            Select state = new Select(driver.findElement(By.id("id_state")));
            state.selectByValue("5");
            driver.findElement(By.id("postcode")).sendKeys("91331");
            driver.findElement(By.id("phone_mobile")).sendKeys("558 555 55 55");
            driver.findElement(By.id("submitAccount")).click();
            logger.info("Register success.");
        } catch (Exception e) {
            takeSnapShot(driver, "/Users/mycelik/Desktop//registerFail.png");
            logger.info("Register fail.");
            Assert.fail();

        }
    }

    public void checkUser() throws Exception {

        String userName;
        try {
            driver.findElement(By.id("header_logo")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")));
            userName = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText();
            Assert.assertEquals(userName, "myc celik");
            logger.info("Username check success.");
        } catch (Exception e) {
            takeSnapShot(driver, "/Users/mycelik/Desktop//usernameFail.png");
            logger.info("Username check fail.");
            Assert.fail();
        }


    }
}
