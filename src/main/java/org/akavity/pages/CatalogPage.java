package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {
    private final SelenideElement tileField = $(By.cssSelector("h1[class='catalog-title']"));

    public SelenideElement getTileField() {
        return tileField;
    }
}
