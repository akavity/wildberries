package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.GeoPage;
import org.akavity.utils.Utils;

import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class GeoSteps {
    GeoPage geoPage = new GeoPage();
    Utils utils = new Utils();

    @Step
    public void clickAddressButton(String address) {
        geoPage.getGeoTitleField().shouldBe(visible);
        log.info("Click address button: {}", address);
        geoPage.getAddressButton(address).scrollTo().click();
    }

    @Step
    public void clickTakeFromHereButton() {
        log.info("Click button 'Take from here'");
        geoPage.getTakeFromHereButton().click();
    }
}
