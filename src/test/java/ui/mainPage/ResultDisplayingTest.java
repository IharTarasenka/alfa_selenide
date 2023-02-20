package ui.mainPage;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ui.base.BaseTest;

import static com.codeborne.selenide.Condition.*;
import static utils.FactorialCalculation.factorialCalculation;

public class ResultDisplayingTest extends BaseTest {

    public static Object[][] inputData() {
        return new Object[][]{
                {(int) (Math.random() * 8 + 1)},
                {(int) (Math.random() * 8 + 13)},
                {(int) (Math.random() * 51 + 250)},
                {(int) (Math.random() * 501 + 1500)},
        };
    }

    @ParameterizedTest
    @MethodSource("inputData")
    public void resultDisplayingFormat(int value) {
        String calculatedValue = String.valueOf(factorialCalculation(value));
        mainPage.inputField.sendKeys(String.valueOf(value));
        mainPage.calculateButton.click();
        mainPage.resultField.shouldBe(not(empty));
        String expected = String.format("The factorial of %d is: %s", value, calculatedValue);
        mainPage.resultField.shouldHave(text(expected));
    }
}
