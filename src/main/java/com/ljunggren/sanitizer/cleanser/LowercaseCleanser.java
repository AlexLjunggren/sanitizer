package com.ljunggren.sanitizer.cleanser;

public class LowercaseCleanser implements Cleanser<String> {

    public String cleanse(String value) {
        return value == null? value : value.toLowerCase();
    }

    public String description() {
        return "Lowercase all characters";
    }

}
