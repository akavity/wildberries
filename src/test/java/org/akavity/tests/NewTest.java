package org.akavity.tests;

import org.akavity.steps.CatalogSteps;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.NavigationSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest extends BaseTest {
    HeaderSteps headerSteps = new HeaderSteps();
    NavigationSteps navigationSteps = new NavigationSteps();
    CatalogSteps catalogSteps = new CatalogSteps();

    @Test
    public void catalogNavigation() {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem("Женщинам");
        navigationSteps.clickDropListItem("Одежда для дома", "Брюки и шорты");

        String actual = catalogSteps.extractTextFromTitle();
        Assert.assertEquals(actual, "Брюки и шорты");
    }
}
