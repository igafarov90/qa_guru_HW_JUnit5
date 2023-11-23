import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;


public class TestBase {

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.baeldung.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserVersion = "118";
    }

    @AfterEach
    protected void reportAndCloseBrowser() {

        closeWebDriver();
    }
}