package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class InfoPage {
    public SelenideElement getServiceMenuItem(String item) {
        return $(By.xpath("//div[@class='service-menu']//a[contains(text(),'" + item + "')]/.."));
    }

    public SelenideElement getDropDownTitle(String title) {
        return $(By.xpath("//h2[contains(@class,'dropdown-t') and contains(text(),'" + title + "')]"));
    }

    public SelenideElement getDropDownContent(String title, String cont) {
        return $(By.xpath("//h2[contains(@class,'dropdown-titl') and contains(text(),'" + title + "')]/..//p[contains(text(),'" + cont + "')]"));
    }

    // Frequently asked questions (FAQ)
    public SelenideElement getFAQMenuItem(String item) {
        return $(By.xpath("//div[contains(@class,'faq-menu')]//span[contains(text(),'" + item + "')]/.."));
    }

    public SelenideElement getFAQTitle(String title) {
        return $(By.xpath("//div[contains(@class,'faq-contain')]//h1[contains(text(),'\" + title + \"')]"));
    }

    public SelenideElement getFAQ(String q) {
        return $(By.xpath("//div[contains(@class,'faq-contain')]//h2[contains(text(),'" + q + "')]"));
    }

    private final SelenideElement serviceIframe = $(By.cssSelector("iframe[id='pageInfoIfr']"));

    public SelenideElement getServiceIframe() {
        return serviceIframe;
    }
}
