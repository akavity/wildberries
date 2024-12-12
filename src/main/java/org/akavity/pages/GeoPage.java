package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GeoPage {
    private final SelenideElement pickUpPointButton = $(By.xpath("//div[contains(@class,'geo-block__info')]//span[contains(text(),'Пункт выдачи')]"));
    private final SelenideElement deliveryButton = $(By.xpath("//div[contains(@class,'geo-block__info')]//span[contains(text(),'Курьером')]"));

    public SelenideElement getAddressButton(String address) {
        return $(By.xpath("//span[contains(@class,'address-item__n')]/span[contains(text(),'" + address + "')]/../../.."));
    }

    // PickUp point block
    private final SelenideElement takeFromHereButton = $(By.cssSelector("button[class*='details-self__btn']"));

    public SelenideElement addressField(String address) {
        return $(By.xpath("//div[@class='details-self__name']/span[contains(text(),'" + address + "')]"));
    }

    public SelenideElement getPickUpPointButton() {
        return pickUpPointButton;
    }

    public SelenideElement getDeliveryButton() {
        return deliveryButton;
    }

    public SelenideElement getTakeFromHereButton() {
        return takeFromHereButton;
    }
}
