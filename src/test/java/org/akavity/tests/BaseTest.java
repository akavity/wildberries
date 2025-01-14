package org.akavity.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.ResourceBundle;
import java.util.logging.Level;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    private final ResourceBundle bundle = ResourceBundle.getBundle("test_framework");
    private final String URL = bundle.getString("path_to_url");

    @BeforeClass
    public void start() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .enableLogs(LogType.BROWSER, Level.ALL));

        Configuration.browserSize = "1920x1080";
        Configuration.browser = CHROME;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // Disable notifications
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }

    @BeforeMethod
    public void goToUrl() {
        open(URL);
    }

    @AfterMethod
    public void clearData() {
        clearBrowserLocalStorage();
        clearBrowserCookies();
        closeWebDriver();
    }
}
