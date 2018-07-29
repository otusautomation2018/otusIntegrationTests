package ru.yandex.translate;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.yandex.translate.site.YandexTranslateSite;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.jdi.uitests.web.selenium.driver.WebDriverUtils.killAllRunWebBrowsers;

public class TestsInit extends TestNGBase {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(YandexTranslateSite.class);
        logger.info("Run Tests");
    }
    @AfterSuite(alwaysRun = true)
    public static void tearDown()  {
        killAllRunWebBrowsers();
    }
}
