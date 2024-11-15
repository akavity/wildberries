package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.CatalogPage;

import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class CatalogSteps {
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";
    CatalogPage catalogPage = new CatalogPage();

    @Step
    public void clickMainListItem(String item) {
        log.info("CLick main-list item: {}", item);
        catalogPage.getMailListElement().shouldBe(visible);
        catalogPage.getMainListItem(item)
                .scrollIntoView(PARAMETER)
                .click();
    }

    @Step
    public void clickDropListItem(String item) {
        log.info("Click drop list item: {}", item);
        catalogPage.getDropListItem(item)
                .scrollIntoView(PARAMETER)
                .click();
    }
}
