package org.akavity.tests;

import org.akavity.steps.CatalogSteps;
import org.akavity.steps.ProductSteps;
import org.akavity.steps.UserActivitySteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    CatalogSteps catalogSteps = new CatalogSteps();
    ProductSteps productSteps = new ProductSteps();
    UserActivitySteps userActivitySteps = new UserActivitySteps();

    @Test(description = "Look at reviews")
    public void lookAtReviews() {
        catalogSteps.selectFirstProductCard();
        productSteps.clickViewAllButton();

        Assert.assertTrue(userActivitySteps.isFeedbackButtonDisplayed());
    }
}
