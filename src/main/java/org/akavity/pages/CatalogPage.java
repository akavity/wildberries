package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {
    private final SelenideElement mailListElement = $(By.cssSelector("ul[class='menu-burger__main-list']"));

    public SelenideElement getMainListItem(String item) {
        return $(By.xpath("//ul[contains(@class,'main-list')]//a[.='" + item + "']/.."));
    }

    public SelenideElement getDropListItem(String item) {
        return $(By.xpath("//div[@data-menu-id='306']//a[.='" + item + "']/.."));
    }

    public SelenideElement getMailListElement() {
        return mailListElement;
    }
}
