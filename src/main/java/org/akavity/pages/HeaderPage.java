package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
    private final SelenideElement catalogButton = $(By.cssSelector("button[data-wba-header-name='Catalog']"));
    private final SelenideElement searchField = $(By.cssSelector("input[id='searchInput']"));
    private final SelenideElement loupeButton = $(By.cssSelector("button[id='applySearchBtn']"));

    public SelenideElement getCatalogButton() {
        return catalogButton;
    }

    public SelenideElement getSearchField() {
        return searchField;
    }

    public SelenideElement getLoupeButton() {
        return loupeButton;
    }
}
