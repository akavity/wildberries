package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HeaderPage {
    private final SelenideElement catalogButton = $(By.cssSelector("button[data-wba-header-name='Catalog']"));
    private final SelenideElement searchField = $(By.cssSelector("input[id='searchInput']"));
    private final SelenideElement loupeButton = $(By.cssSelector("button[id='applySearchBtn']"));
    private final SelenideElement addressButton = $(By.cssSelector("div[class*='item-addresses']"));
    private final SelenideElement iframe = $(By.cssSelector("iframe[class='service-page__iframe']"));

    public SelenideElement getServiceMenuItem(String item) {
        return $(By.xpath("//li[contains(@class,'service-menu__item')]/a[contains(text(),'" + item + "')]"));
    }

    public SelenideElement getServiceMenuTitle(String title) {
        return $(By.xpath("//div[@class='service-page-iframe']//h1[contains(text(),'" + title + "')]"));
    }

    public SelenideElement getCatalogButton() {
        return catalogButton;
    }

    public SelenideElement getSearchField() {
        return searchField;
    }

    public SelenideElement getLoupeButton() {
        return loupeButton;
    }

    public SelenideElement getAddressButton() {
        return addressButton;
    }

    public SelenideElement getIframe() {
        return iframe;
    }
}
