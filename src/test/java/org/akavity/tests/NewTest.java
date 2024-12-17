package org.akavity.tests;

import org.akavity.annotations.TestData;
import org.akavity.models.*;
import org.akavity.steps.*;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest extends BaseTest {
    HeaderSteps headerSteps = new HeaderSteps();
    NavigationSteps navigationSteps = new NavigationSteps();
    CatalogSteps catalogSteps = new CatalogSteps();
    FilterDropDownSteps filterDDSteps = new FilterDropDownSteps();
    GeoSteps geoSteps = new GeoSteps();
    PromoSteps promoSteps = new PromoSteps();

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

    @TestData(jsonFile = "searchData", model = "SearchData")
    @Test(description = "Search by product name", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void productSearch(SearchData searchData) {
        headerSteps.enterTextInSearchField(searchData.getText());
        headerSteps.clickLoupeButton();

        Assert.assertTrue(catalogSteps.doProductNamesContainText(searchData.getText()));
    }

    @TestData(jsonFile = "serviceMenuData", model = "ServiceMenuData")
    @Test(description = "Service menu navigation", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void serviceMenuNavigation(ServiceMenuData serviceMenuData) {
        headerSteps.clickAddressButton();
        headerSteps.clickServiceMenuItem(serviceMenuData.getItem());

        Assert.assertTrue(headerSteps.isTitleVDisplayed(serviceMenuData.getTitle()));
    }

    @TestData(jsonFile = "currencyData", model = "CurrencyData")
    @Test(description = "Select currency", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectCurrency(CurrencyData currencyData) {
        headerSteps.selectCurrency(currencyData.getCurrency());

        Assert.assertTrue(catalogSteps.isCurrencyCorrect(currencyData.getSymbol()));
    }

    @TestData(jsonFile = "deliveryData", model = "DeliveryData")
    @Test(description = "Select pick up point", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectPickUpPoint(DeliveryData deliveryData) {
        headerSteps.clickGeolocationButton();
        geoSteps.clickAddressButton(deliveryData.getAddress());
        geoSteps.clickTakeFromHereButton();

        Assert.assertTrue(headerSteps.isAddressPickUpPointDisplayed(deliveryData.getAddress()));
    }

    @TestData(jsonFile = "belGoodsData", model = "BelGoodsData")
    @Test(description = "Select belarusian good", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectBelarusianGood(BelGoodsData belGoods) {
        headerSteps.clickCatalogButton();
        navigationSteps.hoverMainListItem(belGoods.getMainListItem());
        navigationSteps.clickDropListItem(belGoods.getMainListItem(), belGoods.getFirstDropListItem(), belGoods.getSecondDropListItem());
        promoSteps.clickContentItem(belGoods.getFirstContentItem(), belGoods.getSecondContentItem(), belGoods.getThirdContentItem());

        String actual = catalogSteps.extractTextFromTitle();
        Assert.assertEquals(actual, belGoods.getTitle());
    }
}
