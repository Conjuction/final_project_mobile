package tests.browserstack;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static io.appium.java_client.AppiumBy.id;

public class WikipediaTests extends TestBase {

    @DisplayName("Checking text in due order")
    @Tag("browserstack")
    @Owner("Sukhinin Dmitrii")
    @Test
    void checkButtonLogIn() {

        step("Click on the NavBar Menu button", () -> {
            $(id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });
        step("Check button log in", () -> {
            $(id("org.wikipedia.alpha:id/explore_overflow_account_name")).shouldHave(text("Log in to Wikipedia"));
            $(id("org.wikipedia.alpha:id/explore_overflow_account_name")).click();
        });
        step("Check text on button at login form", () -> {
            $(id("org.wikipedia.alpha:id/login_button")).shouldHave(text("Log in"));
        });
    }

    @DisplayName("Проверка открытия статьи с ошибкой")
    @Tag("browserstack")
    @Owner("Sukhinin Dmitrii")
    @Test
    void openArticleWithErrorTest() {

        step("Go to search input and type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("GitHub");
        });
        step("Go to article", () ->
                $(id("org.wikipedia.alpha:id/view_card_header_subtitle")).click());
        step("Verify article opens with error", () ->
                $(id("org.wikipedia.alpha:id/view_wiki_error_text"))
                        .shouldHave(exactText("An error occurred")));
    }
}

