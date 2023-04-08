package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class WikipediaTests extends TestBase {

    @Owner("Sukhinin Dmitrii")
    @Test
    @DisplayName("Checking onboarding screen")
    void checkOnboardingScreen() {
        step("getting started check", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("The Free Encyclopedia …in over 300 languages"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("New ways to explore"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("Reading lists with sync"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldBe(text("Send anonymous data"));
            $(id("org.wikipedia.alpha:id/acceptButton")).click();
            $(id("org.wikipedia.alpha:id/main_toolbar_wordmark")).shouldBe(visible);
        });
    }

    @Owner("Sukhinin Dmitrii")
    @Test
    @DisplayName("Checking text in due order")
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

}
