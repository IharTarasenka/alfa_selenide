package ui.mainPage;

import com.codeborne.selenide.Configuration;
import com.org.page.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ui.base.BaseTest;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.open;
import static ui.utils.MainPageChecker.incorrectInputErrorCheck;

public class InputDataTypeTest extends BaseTest {

    public static Object[][] dataTypes() {
        return new Object[][]{
                {"1.1"},
                {"1,1"},
                {"1+1"},
                {"1e"},
                {"-1"}
        };
    }

    @BeforeEach
    public void init() {
        Configuration.startMaximized = true;
        open("https://qainterview.pythonanywhere.com/");
        mainPage = new MainPage();
    }

    @ParameterizedTest
    @MethodSource("dataTypes")
    public void inputDataTypeValidation(String num) {
        mainPage.inputField.sendKeys(num);
        mainPage.calculateButton.click();
        mainPage.resultField.shouldBe(not(empty));
        incorrectInputErrorCheck(mainPage);
    }
}
