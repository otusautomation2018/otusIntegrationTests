package ru.yandex.translate;

import com.epam.matcher.testng.Assert;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.translate.enums.EndpointURI;
import ru.yandex.translate.enums.LanguageFormats;

import static ru.yandex.translate.site.YandexTranslateSite.homePage;
import static ru.yandex.translate.data.CommonForTheSiteData.*;

public class YandexTranslateTests extends TestsInit {

    @DataProvider
    public Object[][] translateData(){
        return new Object[][] {
                {"live", LanguageFormats.ER_RU.getValue()},
                {"wolf", LanguageFormats.ER_RU.getValue()}
        };
    }

    @Test(dataProvider = "translateData")
    public void verifyTranslateOnThePageAndInResponseOfHTTPQuery(String toTranslate, String languageFormat){
        String result = translate(toTranslate, languageFormat);
        homePage.open();
        homePage.dataForTranslationForm.toTranslateInput.input(toTranslate);
        homePage.formWithTranslationData.translationText.wait(webElement -> webElement.getText().equals(result),
                TIMEOUT_OF_RELOAD_ELEMENT);
        Assert.areEquals(homePage.formWithTranslationData.translationText.getText(), result);
    }

    @Step
    private String translate(String text, String languageFormat){
        RestAssured.baseURI = TRANSLATE_SERVISE + YANDEX + NET_DOMAIN + API + API_VERSION + TRANSLATE_JSON_POSTFIX;
        String pattern = "?key=%s&text=%s&lang=%s";
        String path = String.format(pattern, API_KEY, text, languageFormat);
        RestAssured.useRelaxedHTTPSValidation();
        String result = RestAssured.given()
                .header("User-Agent", "Mozilla...")
                .header("JWT", "jwt_token")
                .when()
                .get(EndpointURI.TRANSLATE.addPath(path)).andReturn().body().print();
        return JsonPath.read(result, "$.text[" + FIRST_ENTITY_IN_LIST + "]");
    }
}
