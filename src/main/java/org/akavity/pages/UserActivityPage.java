package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UserActivityPage {
    private final SelenideElement feedbackButton = $(By.cssSelector("li[class*='activ'] button[class*='product-feedbacks__title']"));

    public SelenideElement getFeedbackButton() {
        return feedbackButton;
    }
}
