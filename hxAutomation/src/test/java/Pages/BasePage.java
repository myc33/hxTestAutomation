package Pages;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    String baseUrl = "http://automationpractice.com";
    final static Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;
    }

    public void openBrowser() {

        logger.info("Test Başlatıldı.");
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }


    public void downScroll() {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,700)", "");
    }

    public void takeSnapShot(WebDriver driver, String fileWithPath) throws Exception {

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);

    }
}

