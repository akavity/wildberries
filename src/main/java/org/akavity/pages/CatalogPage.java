package org.akavity.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage {
    private final SelenideElement tileField = $(By.cssSelector("h1[class='catalog-title']"));
    private final ElementsCollection pricesFields = $$(By.cssSelector("span[class='price__wrap'] ins"));

    public SelenideElement getTileField() {
        return tileField;
    }

    public ElementsCollection getPricesFields() {
        return pricesFields;
    }
}
