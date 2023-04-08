package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AddLanguagePage;
import pages.SearchPage;
import pages.StartedPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

public class WikipediaTests extends TestBase {
    StartedPage startedPage = new StartedPage();
    SearchPage searchPage = new SearchPage();
    AddLanguagePage addLanguagePage = new AddLanguagePage();

    @Owner("Sukhinin Dmitrii")
    @Test
    @DisplayName("Checking onboarding screen")
    void searchingWikipediaTest() {
        step("Пропускаем шаги", () ->
                back()
        );
        step("Нажимаем на строку ввода", () -> {
            searchPage.clickSearch();
        });
        step("Вводим текст в строку поиска", () -> {
            searchPage.setSearchValue();
        });
        step("Проверяем, что поиск сработал", () -> {
            searchPage.checkResults();
        });
    }

    @Owner("Sukhinin Dmitrii")
    @Test
    void getStartedWikipediaTest() {
        step("Проверяем текст на первом экране приложения", () -> {
            startedPage.firstStartedPageText();
        });
        step("Нажимаем кнопку продолжить и проверяем текст на втором экране", () -> {
            startedPage.forwardButtonClick()
                    .secondStartedPageText();
        });
        step("Нажимаем кнопку продолжить и проверяем текст на третьем экране", () -> {
            startedPage.forwardButtonClick()
                    .thirdStartedPageText();
        });
        step("Нажимаем кнопку продолжить и проверяем текст на четвертом экране", () -> {
            startedPage.forwardButtonClick()
                    .fourthStartedPageText();
        });
        step("Нажимаем кнопку Начать и проверяем наличие строки поиска", () -> {
            startedPage.checkStartedPage();
        });
    }
    @Owner("Sukhinin Dmitrii")
    @Test
    void addLanguage() {
        step("Проверяем текст на первом экране приложения", () -> {
            startedPage.firstStartedPageText();
        });
        step("Пропускаем шаги", () -> {
            back();
        });
        step("Нажимаем на иконку меню с настройками", () -> {
            addLanguagePage.clickMenuButton();
        });
        step("Выбираем пункт настройки", () -> {
            addLanguagePage.clickSettingsButton();
        });
        step("Добавляем новый язык", () -> {
            addLanguagePage.clickAddLanguageButton()
                    .setLanguage();
        });
        step("Проверяем, что добавлен новый язык", () -> {
            addLanguagePage.checkLanguage();
        });
    }
}

