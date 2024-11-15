package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.CatalogPage;

import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class CatalogSteps {
    CatalogPage catalogPage = new CatalogPage();

    @Step
    public String extractTextFromTitle() {
        return catalogPage.getTileField().shouldBe(visible).text();
    }
}
