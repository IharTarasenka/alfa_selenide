package ui.mainPage;

import org.junit.jupiter.api.Test;
import ui.base.BaseTest;

import static com.codeborne.selenide.Condition.*;

public class ContentTest extends BaseTest {

    @Test
    public void search() {
        mainPage.header.shouldBe(visible);
        mainPage.header.shouldHave(text("The greatest factorial calculator!"));
    }

    @Test
    public void inputField() {
        mainPage.inputField.shouldBe(visible);
        mainPage.inputField.shouldBe(enabled);
        mainPage.inputField.shouldHave(attribute("placeholder", "Enter an integer"));
    }

    @Test
    public void calculateButton() {
        mainPage.calculateButton.shouldBe(visible);
        mainPage.calculateButton.shouldBe(enabled);
    }
}
