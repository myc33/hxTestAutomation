package RestTest;

import Pages.ProductPage;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class ServicesTest {

    @Test
    public void successTest() {
        final Logger logger = Logger.getLogger(ServicesTest.class);
        int statusCode = 0;

        Response response = RestAssured.given().filter(new AllureRestAssured())
                .contentType("application/json")
                .when()
                .get("https://generator.swagger.io/api/swagger.json")
                .then()
                .log()
                .all()
                .extract()
                .response();

        statusCode = response.getStatusCode();
        logger.info("Status Code:" + statusCode);
        if (statusCode == 200) {
            logger.info("Test basarılı");
        }
        else {
            logger.info("Status Code:" + statusCode + "\nTest basarısız");
            Assert.fail();

        }
    }

    @Test
    public void failTest() {
        final Logger logger = Logger.getLogger(ServicesTest.class);
        int statusCode = 0;

        Response response = RestAssured.given().filter(new AllureRestAssured())
                .contentType("application/json")
                .when()
                .post("https://generator.swagger.io/api/swagger.json")
                .then()
                .log()
                .all()
                .extract()
                .response();

        statusCode = response.getStatusCode();
        if (statusCode == 200) {
            logger.info("Status Code:" + statusCode + "\nTest basarılı");

        }
        else {
            logger.info("Status Code:" + statusCode + "\nTest basarısız");
            Assert.fail();

        }
    }
}
