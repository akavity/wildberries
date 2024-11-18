package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class NavigationPage {
    private final SelenideElement mailListElement = $(By.cssSelector("ul[class='menu-burger__main-list']"));

    public SelenideElement getMainListItem(String item) {
        return $(By.xpath("//ul[contains(@class,'main-list')]//a[.='" + item + "']/.."));
    }

    public SelenideElement getFirstDropListItem(String itemML, String itemDL) {
        String id = getId(itemML);
        return $(By.xpath("//div[@data-menu-id='" + id + "']//div[contains(@class,'burger__first')]//a[.='" + itemDL + "'] " +
                "| //div[@data-menu-id='" + id + "']//div[contains(@class,'burger__first')]//span[.='" + itemDL + "']"));
    }

    public SelenideElement getSecondDropListItem(String itemML, String itemDL) {
        String id = getId(itemML);
        return $(By.xpath("//div[@data-menu-id='" + id + "']//div[contains(@class,'burger__second')]//a[contains(text(),'" + itemDL + "')]"));
    }

    public SelenideElement getDropListTitle(String itemML, String title) {
        String id = getId(itemML);
        return $(By.xpath("//div[@data-menu-id='" + id + "']//span[contains(@class,'title-name') and contains(text(),'" + title + "')]"));
    }

    public SelenideElement getMailListElement() {
        return mailListElement;
    }

    private String getId(String itemDL) {
        String id = "";
        switch (itemDL.toLowerCase()) {
            case "женщинам" -> id = "306";
            case "обувь" -> id = "629";
            case "детям" -> id = "115";
            default -> log.info("Incorrect item name: {}", itemDL);
        }
        log.info("Dropdown list item: \"{}\" have id: {}", itemDL, id);
        return id;
    }
}
