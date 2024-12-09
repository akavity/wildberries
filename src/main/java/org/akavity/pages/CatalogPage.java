package org.akavity.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage {
    private final SelenideElement tileField = $(By.cssSelector("h1[class='catalog-title']"));
    private final ElementsCollection pricesFields = $$(By.cssSelector("span[class='price__wrap'] ins"));
    private final ElementsCollection productNames = $$(By.cssSelector("span[class='product-card__name']"));

    public SelenideElement getSearchTitleField(String title) {
        return $(By.xpath("//h1[@class='searching-results__title' and contains(text(),'" + title + "')]"));
    }

    public SelenideElement getTileField() {
        return tileField;
    }

    public ElementsCollection getPricesFields() {
        return pricesFields;
    }

    public ElementsCollection getProductNames() {
        return productNames;
    }
}
