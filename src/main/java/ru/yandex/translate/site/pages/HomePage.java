package ru.yandex.translate.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.translate.site.sections.FormOfDataForTranslation;
import ru.yandex.translate.site.sections.FormWithTranslationData;

@JPage(title = "Яндекс.Переводчик – словарь и онлайн перевод на английский, русский, немецкий, французский, украинский и другие языки.")
public class HomePage extends WebPage {

    @FindBy(css = ".container_main .item_left")
    public FormOfDataForTranslation dataForTranslationForm;

    @FindBy(css = ".container_main .item_right")
    public FormWithTranslationData formWithTranslationData;
}
