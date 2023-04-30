package tests;

import org.junit.jupiter.api.Test;
import pages.HomePage;

public class FirstSelenideTest extends BaseTest {

    HomePage homePage = new HomePage();

    @Test
    public void firstTest() {
       homePage
               .openPage()
               .checkRegisterButtonText("Зарегистрироваться");
    }
}