package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.FilterDropDownPage;

@Log4j2
public class FilterDropDownSteps {
    FilterDropDownPage filter = new FilterDropDownPage();

    @Step
    public void clickButtonDDF(String button) {
        log.info("Click dropdown-filter button: {}", button);
        filter.getButtonDDF(button).hover().click();
    }

    @Step
    public void selectSortType(String type) {
        log.info("Select sort type: {}", type);
        filter.getRadioButtonDDF(type).click();
    }

    @Step
    public void enterMinAmount(String min) {
        log.info("Enter min amount: {}", min);
        filter.getMinPriceDDF().setValue(min);
    }

    @Step
    public void enterMaxAmount(String max) {
        log.info("Enter max amount: {}", max);
        filter.getMaxPriceDDF().setValue(max);
    }

    @Step
    public void clickPriceReadyButton() {
        log.info("Click \"Price is ready\" button");
        filter.getPriceReadyButtonDDF().click();
    }
}
