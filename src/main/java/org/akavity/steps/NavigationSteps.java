package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.NavigationPage;
import org.akavity.utils.Utils;

import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class NavigationSteps {
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";
    NavigationPage navigationPage = new NavigationPage();
    Utils utils = new Utils();

    @Step
    public void clickMainListItem(String item) {
        log.info("CLick main-list item: {}", item);
        navigationPage.getMailListElement().shouldBe(visible);
        navigationPage.getMainListItem(item).click();
    }

    @Step
    public void clickDropListItem(String item1, String item2) {
        log.info("Click first item of drop list: {}", item1);
        utils.sleep(2000);
        navigationPage.getDropListItem(item1).click();
        if (item2.equalsIgnoreCase("no")) {
            log.info("Drop list doesn't have second item");
        } else {
            log.info("Drop list have second item: {}", item1);
            navigationPage.getDropListTitle(item1).shouldBe(visible);
            navigationPage.getDropListItem(item2).click();
        }
    }
}
