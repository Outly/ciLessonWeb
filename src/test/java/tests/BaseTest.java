package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BaseTest {

    public static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

    @BeforeAll
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1366x768";
        Configuration.timeout = 5000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
    }
    @AfterAll
    public static void turnDown() {
        Selenide.closeWebDriver();
    }
}