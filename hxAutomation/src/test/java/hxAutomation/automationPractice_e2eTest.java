package hxAutomation;

import Pages.*;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class automationPractice_e2eTest {

    WebDriver driver;
    WebDriverWait wait;

    @Step("Open <browserName> browser")
    public void open_browser(String browserName) {
        switch (browserName) {
            case "chrome": {
                driver = new ChromeDriver();
                break;
            }
            case "firefox": {
                driver = new FirefoxDriver();
                break;
            }
            default:
                driver = new FirefoxDriver();
        }
        wait = new WebDriverWait(driver, 10);
        BasePage basePage = new BasePage(driver, wait);
        basePage.openBrowser();
    }


    @Step("Close browser")
    public void close() {
        driver.close();
    }

    @Step("Register")
    public void register() throws Exception {

        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.register();
    }

    @Step("Check username")
    public void checkUsername() throws Exception {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.checkUser();

    }

    @Step("Add products in basket")
    public void addProduct() throws Exception {
        ProductPage productPage = new ProductPage(driver, wait);
        productPage.goToSummerDress();
        productPage.addCart("16");
        productPage.searchProduct("summer");
        productPage.addCart("14");

    }

    @Step("Complete shopping")
    public void completeShopping() throws Exception {
        BasketPage basketPage = new BasketPage(driver,wait);
        AddressPage addressPage = new AddressPage(driver,wait);
        ShippingPage shippingPage = new ShippingPage(driver,wait);
        PaymentPage paymentPage = new PaymentPage(driver,wait);
        basketPage.goToBasket();
        basketPage.checkproductPrice();
        basketPage.checkQuantity();
        basketPage.goToSelectAdress();
        addressPage.goToSelectShipping();
        shippingPage.checkCheckBoxAndGoToPayment();
        paymentPage.selectPaymentType();
        paymentPage.completeOrder();
        paymentPage.goToOrders();


    }
}
