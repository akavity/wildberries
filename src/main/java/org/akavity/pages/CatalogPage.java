package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {
    private final SelenideElement tileField = $(By.cssSelector("h1[class='catalog-title']"));

    // Drop Down Filter
    private final SelenideElement minPriceDDF = $(By.cssSelector("div[class*='filter__price'] input[name*='start']"));
    private final SelenideElement maxPriceDDF = $(By.cssSelector("div[class*='filter__price'] input[name*='end']"));
    private final SelenideElement priceReadyButtonDDF = $(By.xpath("//button[contains(@class,'filter-btn') and contains(.,'Готово')]"));

    public SelenideElement getButtonDDF(String name) {
        return $(By.xpath("//div[contains(@class,'filter__btn') and contains(.,'" + name + "')]"));
    }

    public SelenideElement getRadioButtonDDF(String name) {
        return $(By.xpath("//span[contains(@class,'radio-with-text') and contains(.,'" + name + "')]"));
    }

    public SelenideElement getCheckBoxDDF(String name) {
        return $(By.xpath("//span[@class='checkbox-with-text__text' and .='" + name + "']"));
    }

    public SelenideElement getMinPriceDDF() {
        return minPriceDDF;
    }

    public SelenideElement getMaxPriceDDF() {
        return maxPriceDDF;
    }

    public SelenideElement getPriceReadyButtonDDF() {
        return priceReadyButtonDDF;
    }

    public SelenideElement getTileField() {
        return tileField;
    }
}
