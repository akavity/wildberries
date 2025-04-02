package org.akavity.tests;

import org.akavity.annotations.TestData;
import org.akavity.models.sortTest.AscendingPriceData;
import org.akavity.models.sortTest.PriceData;
import org.akavity.steps.CatalogSteps;
import org.akavity.steps.FiltersBlockSteps;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.NavigationSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortTest extends BaseTest {
    HeaderSteps headerSteps = new HeaderSteps();
    NavigationSteps navigationSteps = new NavigationSteps();
    FiltersBlockSteps filtersBlockSteps = new FiltersBlockSteps();
    CatalogSteps catalogSteps = new CatalogSteps();

    @TestData(jsonFile = "priceData", model = "PriceData", folder = "sortTest")
    @Test(description = "Sort products by price within set limits", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void sortProductsByPrice(PriceData price) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(price.getMainListItem());
        navigationSteps.clickDropListItem(price.getMainListItem(), price.getFirstDropListItem(), price.getSecondDropListItem());
        filtersBlockSteps.clickFilterButton(price.getButton());
        filtersBlockSteps.enterMinMaxAmount(price.getMinPrice(), price.getMaxPrice());

        Assert.assertTrue(catalogSteps.areProductPricesWithinLimit(price.getMinPrice(), price.getMaxPrice()));
    }

    @TestData(jsonFile = "ascendingPriceData", model = "AscendingPriceData", folder = "sortTest")
    @Test(description = "Sort products by ascending price", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void sortByAscendingPrice(AscendingPriceData ascendingPrice) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(ascendingPrice.getMainListItem());
        navigationSteps.clickDropListItem(ascendingPrice.getMainListItem(), ascendingPrice.getFirstDropListItem(), ascendingPrice.getSecondDropListItem());
        filtersBlockSteps.clickSorterButton();
        filtersBlockSteps.selectSortType(ascendingPrice.getSortType());

        Assert.assertTrue(catalogSteps.checkSortByAscendingPrice(ascendingPrice.getElements()));
    }
}
