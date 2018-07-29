package ru.yandex.translate.enums;

public enum LanguageFormats {
    ER_RU("en-ru");

    String value;

    LanguageFormats(String value) { this.value = value; }

    public String getValue() {
        return value;
    }


}
