package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ProductPage;

@Log4j2
public class ProductSteps {
    ProductPage productPage = new ProductPage();

    @Step
    public void clickCommentsButton() {
        log.info("Click comments button");
        productPage.getCommentsButton().scrollTo().click();
    }

    @Step
    public void clickQuestionsButton() {
        log.info("Click questions button");
        productPage.getQuestionsButton().click();
    }

    @Step
    public void clickViewAllButton() {
        log.info("Click \"View All\" button");
        productPage.getViewAllButton().scrollTo().click();
    }
}
