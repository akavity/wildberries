package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavigationPage {
    private final SelenideElement mailListElement = $(By.cssSelector("ul[class='menu-burger__main-list']"));

    public SelenideElement getMainListItem(String item) {
        return $(By.xpath("//ul[contains(@class,'main-list')]//a[.='" + item + "']/.."));
    }

    public SelenideElement getDropListItem(String item) {
        return $(By.xpath("//div[@data-menu-id='306']//a[contains(text(),'" + item + "')]/.. | //div[@data-menu-id='306']//span[contains(text(),'" + item + "')]"));
    }
    //div[@data-menu-id='306']//a[.='" + item + "']/.. | //div[@data-menu-id='306']//span[.='" + item + "']
    public SelenideElement getDropListTitle(String title) {
        return $(By.xpath("//div[@data-menu-id='306']//span[contains(@class,'title-name') and contains(text(),'" + title + "')]"));
    }

    public SelenideElement getMailListElement() {
        return mailListElement;
    }
}