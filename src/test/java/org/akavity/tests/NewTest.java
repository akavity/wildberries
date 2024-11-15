package org.akavity.tests;

import org.akavity.steps.HeaderSteps;
import org.akavity.utils.Utils;
import org.testng.annotations.Test;

public class NewTest extends BaseTest {
    HeaderSteps headerSteps = new HeaderSteps();
    Utils utils = new Utils();

    @Test
    public void catalogNavigation() {
        headerSteps.clickCatalogButton();
        utils.sleep(3000);
    }
}
