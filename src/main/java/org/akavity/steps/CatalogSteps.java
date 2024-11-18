package org.akavity.steps;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.CatalogPage;
import org.akavity.utils.Utils;

import java.util.function.Predicate;

import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class CatalogSteps {
    CatalogPage catalogPage = new CatalogPage();
    Utils utils = new Utils();

    @Step
    public String extractTextFromTitle() {
        String title = catalogPage.getTileField().shouldBe(visible).text();
        log.info("Catalog title: {}", title);
        return title;
    }

    @Step
    public boolean areProductPricesWithinLimit(String min, String max) {
        log.info("Check product prices \n min price: {} \n max price: {}", min, max);
        utils.sleep(1500);
        ElementsCollection prices = catalogPage.getPricesFields();
        Predicate<Double> predicate = p -> (p >= Integer.parseInt(min) && p <= Integer.parseInt(max));
        return utils.relationalMethod(prices, predicate);
    }
}
