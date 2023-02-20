package ui.base;

import com.org.page.MainPage;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    protected MainPage mainPage;

    @BeforeEach
    public void setUp() {
        mainPage = new MainPage();
        open(mainPage.MAIN_PAGE_URL);
    }
}
