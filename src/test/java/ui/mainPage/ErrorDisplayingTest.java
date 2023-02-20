package ui.mainPage;

import org.junit.jupiter.api.Test;
import ui.base.BaseTest;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.not;
import static ui.utils.MainPageChecker.incorrectInputErrorCheck;

public class ErrorDisplayingTest extends BaseTest {

    @Test
    public void errorDisplaying() {
        mainPage.inputField.sendKeys("test");
        mainPage.calculateButton.click();
        mainPage.resultField.shouldBe(not(empty));
        incorrectInputErrorCheck(mainPage);
    }
}
