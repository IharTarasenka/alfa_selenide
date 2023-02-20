package com.org.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    public static final String MAIN_PAGE_URL = "https://qainterview.pythonanywhere.com/";
    public SelenideElement header = $x("//h1");
    public SelenideElement inputField = $(byId("number"));
    public SelenideElement calculateButton = $x("//button[@type='submit']");
    public SelenideElement resultField = $(byId("resultDiv"));

}
