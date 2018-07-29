package ru.yandex.translate.site;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import ru.yandex.translate.data.PagesUrl;
import ru.yandex.translate.site.pages.HomePage;

@JSite(PagesUrl.HOME_PAGE)
public class YandexTranslateSite extends WebSite {
    public static HomePage homePage;

}
