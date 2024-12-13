package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.GeoPage;

@Log4j2
public class GeoSteps {
    GeoPage geoPage = new GeoPage();

    @Step
    public void clickAddressButton(String address) {
        log.info("Click address button: {}", address);
        geoPage.getAddressButton(address).scrollTo().click();
    }

    @Step
    public void clickTakeFromHereButton() {
        log.info("Click button 'Take from here'");
        geoPage.getTakeFromHereButton().click();
    }
}
