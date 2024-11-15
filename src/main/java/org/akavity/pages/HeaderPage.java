package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
    private final SelenideElement catalogButton = $(By.cssSelector("button[data-wba-header-name='Catalog']"));

    public SelenideElement getCatalogButton() {
        return catalogButton;
    }
}