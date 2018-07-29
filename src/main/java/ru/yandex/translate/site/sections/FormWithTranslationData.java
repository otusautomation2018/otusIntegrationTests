package ru.yandex.translate.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;

public class FormWithTranslationData extends Form {

    @FindBy(css = "#translation")
    public Text translationText;
}
