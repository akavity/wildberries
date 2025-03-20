package org.akavity.tests;

import org.akavity.annotations.TestData;
import org.akavity.models.FaqData;
import org.akavity.models.RefundData;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.InfoSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FAQTest extends OldBaseTest {
    HeaderSteps headerSteps = new HeaderSteps();
    InfoSteps infoSteps = new InfoSteps();

    @TestData(jsonFile = "faqData", model = "FaqData")
    @Test(description = "Select frequently asked question", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void selectFAQ(FaqData faqData) {
        headerSteps.clickAddressButton();
        infoSteps.clickServiceMenuItem(faqData.getServiceMenuItem());
        infoSteps.clickFAQMenuItem(faqData.getFaqMenuItem());

        Assert.assertTrue(infoSteps.isFAQTitleDisplayed(faqData.getTitle()));
    }

    @TestData(jsonFile = "refundData", model = "RefundData")
    @Test(description = "Check refund information", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void checkRefundInfo(RefundData refundData) {
        headerSteps.clickAddressButton();
        infoSteps.clickServiceMenuItem(refundData.getMenuItem());
        infoSteps.clickDropDownTitle(refundData.getTitle());

        Assert.assertTrue(infoSteps.isDropDownContentDisplayed(refundData.getTitle(), refundData.getContent()));
    }
}
