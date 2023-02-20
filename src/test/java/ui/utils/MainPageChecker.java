package ui.utils;

import com.org.page.MainPage;

import static com.codeborne.selenide.Condition.*;

public class MainPageChecker {

    public static void incorrectInputErrorCheck(MainPage mainPage){
        mainPage.inputField.shouldHave(attribute("style", "border: 2px solid red;"));
        mainPage.resultField.shouldHave(text("Please enter an integer"));
        mainPage.resultField.shouldHave(attribute("style", "color: rgb(255, 0, 0);"));
    }
}
