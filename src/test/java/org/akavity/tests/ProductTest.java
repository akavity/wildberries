package org.akavity.tests;

import org.akavity.steps.CatalogSteps;
import org.akavity.steps.PopupSteps;
import org.akavity.steps.ProductSteps;
import org.akavity.steps.UserActivitySteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends OldBaseTest {
    CatalogSteps catalogSteps = new CatalogSteps();
    ProductSteps productSteps = new ProductSteps();
    UserActivitySteps userActivitySteps = new UserActivitySteps();
    PopupSteps popupSteps = new PopupSteps();

    @Test(description = "Look at reviews")
    public void lookAtReviews() {
        catalogSteps.selectFirstProductCard();
        productSteps.clickViewAllCommentsButton();

        Assert.assertTrue(userActivitySteps.isFeedbackButtonDisplayed());
    }

    @Test(description = "Look at Questions")
    public void lookAtQuestions() {
        catalogSteps.selectFirstProductCard();
        productSteps.clickQuestionsButton();
        productSteps.clickViewAllQuestionButton();

        Assert.assertTrue(userActivitySteps.isQuestionTitleDisplayed());
    }

    @Test(description = "Open product popup")
    public void openProductPopup() {
        String cardBrand = catalogSteps.getFirstProductCardBrand();
        double cardPrice = catalogSteps.getFirstProductCardPrice();
        catalogSteps.clickFirstPopupButton();
        String popupBrand = popupSteps.getProductBrand();
        double popupPrice = popupSteps.getProductPrice();

        Assert.assertTrue(popupSteps.isPopupBlockDisplayed());
        Assert.assertEquals(cardBrand, popupBrand);
        Assert.assertEquals(cardPrice, popupPrice);
    }
}
