package org.akavity.steps;

import lombok.extern.log4j.Log4j2;
import org.akavity.pages.GeoPage;
import org.testng.annotations.Test;

@Log4j2
public class GeoSteps {
    GeoPage geoPage = new GeoPage();

    @Test
    public void clickAddressButton(String address) {
        log.info("Click address button: {}", address);
        geoPage.getAddressButton(address).click();
    }

    @Test
    public void clickTakeFromHereButton() {
        log.info("Click button 'Take from here'");
        geoPage.getTakeFromHereButton().click();
    }
}
