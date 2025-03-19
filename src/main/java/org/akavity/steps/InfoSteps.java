package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.InfoPage;
import org.akavity.utils.Utils;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.switchTo;

@Log4j2
public class InfoSteps {
    InfoPage infoPage = new InfoPage();
    Utils utils = new Utils();

    @Step
    public void clickServiceMenuItem(String item) {
        log.info("Click service menu item: {}", item);
        infoPage.getServiceMenuItem(item).shouldBe(clickable).click();
    }

    @Step
    public void clickFAQMenuItem(String item) {
        log.info("Click FAQ menu item: {}", item);
        switchTo().frame(infoPage.getServiceIframe());                     // Service iframe
        infoPage.getFAQMenuItem(item).click();
    }

    @Step
    public boolean isFAQTitleDisplayed(String title) {
        utils.sleep(1000);
        boolean res = infoPage.getFAQTitle(title).isDisplayed();
        log.info("Is FAQ title displayed: {}", res);
        return res;
    }

    @Step
    public void clickFAQ(String question) {
        log.info("Click FAQ");
        infoPage.getFAQ(question).click();
    }
}
