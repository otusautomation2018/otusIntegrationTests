package ru.yandex.translate.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Input;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;

public class FormOfDataForTranslation extends Form {

    @FindBy(css = "#fakeArea")
    public Input toTranslateInput;

}
