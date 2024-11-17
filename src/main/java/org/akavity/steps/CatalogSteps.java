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
        String title = catalogPage.getTileField().shouldBe(visible).text();
        log.info("Catalog title: {}", title);
        return title;
    }

    @Step
    public void clickButtonDDF(String button) {
        log.info("Click dropdown-filter button: {}", button);
        catalogPage.getButtonDDF(button).hover().click();
    }

    @Step
    public void selectSortType(String type) {
        log.info("Select sort type: {}", type);
        catalogPage.getRadioButtonDDF(type).click();
    }

    @Step
    public void enterMinAmount(String min) {
        log.info("Enter min amount: {}", min);
        catalogPage.getMinPriceDDF().setValue(min);
    }

    @Step
    public void enterMaxAmount(String max) {
        log.info("Enter max amount: {}", max);
        catalogPage.getMaxPriceDDF().setValue(max);
    }

    @Step
    public void clickPriceReadyButton() {
        log.info("Click \"Price is ready\" button");
        catalogPage.getPriceReadyButtonDDF().click();
    }
}
