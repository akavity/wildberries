package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private final SelenideElement commentsButton = $(By.cssSelector("button[id='a-Comments']"));
    private final SelenideElement questionsButton = $(By.cssSelector("button[id='a-Questions']"));
    private final SelenideElement viewAllButton = $(By.cssSelector("div[id='Comments']  a[class*='btn-base comments__btn-all']"));

    public SelenideElement getCommentsButton() {
        return commentsButton;
    }

    public SelenideElement getQuestionsButton() {
        return questionsButton;
    }

    public SelenideElement getViewAllButton() {
        return viewAllButton;
    }
}
