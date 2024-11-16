package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {
    private final SelenideElement tileField = $(By.cssSelector("h1[class='catalog-title']"));

    public SelenideElement getFilterButton(String name) {
        return $(By.xpath("//button[contains(@class,'dropdown-filter') and contains(text(),'" + name + "')]"));
    }

    public SelenideElement getRadioButton(String name) {
        return $(By.xpath("//span[@class='radio-with-text__text' and .='" + name + "']"));
    }

    public SelenideElement getCheckBox(String name) {
        return $(By.xpath("//span[@class='checkbox-with-text__text' and .='" + name + "']"));
    }

    public SelenideElement getTileField() {
        return tileField;
    }
}
