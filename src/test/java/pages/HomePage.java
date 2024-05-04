package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import config.ProjectConfig;
import io.qameta.allure.Severity;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

    private final By REGISTER_BUTTON = By.xpath("//a[@data-testid='header-sign-up-button']/span");

    public HomePage openPage() {
        Selenide.open(config.baseUrl());
        return this;
    }

    public HomePage checkRegisterButtonText(String text) {
        $(REGISTER_BUTTON).shouldBe(Condition.visible).shouldHave(Condition.text(text));
        return this;
    }
}
