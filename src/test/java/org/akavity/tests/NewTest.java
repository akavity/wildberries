package org.akavity.tests;

import org.akavity.annotations.TestData;
import org.akavity.models.CatalogData;
import org.akavity.models.PriceData;
import org.akavity.steps.CatalogSteps;
import org.akavity.steps.FilterDropDownSteps;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.NavigationSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest extends BaseTest {
    HeaderSteps headerSteps = new HeaderSteps();
    NavigationSteps navigationSteps = new NavigationSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    FilterDropDownSteps filterDDSteps = new FilterDropDownSteps();

    @TestData(jsonFile = "catalogData", model = "CatalogData")
    @Test(description = "Catalog navigation", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void catalogNavigation(CatalogData catalog) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(catalog.getMainListItem());
        navigationSteps.clickDropListItem(catalog.getMainListItem(), catalog.getFirstDropListItem(), catalog.getSecondDropListItem());

        String actual = catalogSteps.extractTextFromTitle();
        Assert.assertEquals(actual, catalog.getTitle());
    }

    @TestData(jsonFile = "priceData", model = "PriceData")
    @Test(description = "Check that product prices are within the limit", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void sortProductsByPrice(PriceData price) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(price.getMainListItem());
        navigationSteps.clickDropListItem(price.getMainListItem(), price.getFirstDropListItem(), price.getSecondDropListItem());
        filterDDSteps.clickButtonDDF(price.getButton());
        filterDDSteps.enterMinMaxAmount(price.getMinPrice(), price.getMaxPrice());

        Assert.assertTrue(catalogSteps.areProductPricesWithinLimit(price.getMinPrice(), price.getMaxPrice()));
    }
}
