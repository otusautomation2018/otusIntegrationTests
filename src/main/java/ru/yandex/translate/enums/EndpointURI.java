package ru.yandex.translate.enums;

public enum EndpointURI {
    TRANSLATE("/translate");

    String path;

    EndpointURI(String path){
        this.path = path;
    }

    public String getPath(){
        return path;
    }

    public String addPath(String additionalPath) {
        return path + additionalPath;
    }

}
