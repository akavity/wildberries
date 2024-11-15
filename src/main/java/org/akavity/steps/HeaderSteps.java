package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.HeaderPage;

import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class HeaderSteps {
    HeaderPage headerPage = new HeaderPage();

    @Step
    public void clickCatalogButton() {
        log.info("Click catalog button");
        headerPage.getCatalogButton().shouldBe(visible).click();
    }
}
