package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class WikipediaTests extends TestBase{
    @Tag("browserstack")
    @Owner("Sukhinin Dmitrii")
    @Test
    @DisplayName("Success search")
    void successSearchTest() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Python");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0)));
    }

    @Owner("Sukhinin Dmitrii")
    @Tag("browserstack")
    @Test
    @DisplayName("Open article")
    void openArticleTest() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Iron Maiden");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0)));
        step("Choose page", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).findBy(text("Iron Maiden")).click();
            $(className("android.webkit.WebView")).click();
        });
        step("Verify opened page", () ->
                $(className("android.widget.TextView")).shouldHave(text("Iron Maiden")));
    }

    @Owner("Sukhinin Dmitrii")
    @Test
    @DisplayName("Add language")
    void addLanguageTest() {
        back();
        step("Type search", () ->
                $(accessibilityId("Search Wikipedia")).click());
        step("Add new language", () -> {
            $(id("org.wikipedia.alpha:id/search_lang_button")).click();
            $$(id("org.wikipedia.alpha:id/wiki_language_title")).findBy(text("ADD LANGUAGE")).click();
            $$(id("org.wikipedia.alpha:id/localized_language_name")).findBy(text("Español")).click();
        });
        step("Verify added language", () ->
                $$(className("android.widget.TextView")).findBy(text("Español")).shouldBe(visible));
    }

    @Owner("Sukhinin Dmitrii")
    @Test
    @DisplayName("Onboarding screen")
    void getOnBoardingTest() {
        step("Check 'The Free Encyclopedia …in over 300 languages' text is visible", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });

        step("Click on 'Сontinue'", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check 'New ways to explore' text is visible", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
        });

        step("Click on 'Сontinue'", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check 'Reading lists with sync' text is visible", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
        });

        step("Click on 'Сontinue'", () ->
                $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Check 'Send anonymous data' text is visible", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data"));
        });
    }
}
