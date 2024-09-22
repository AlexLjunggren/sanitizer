package io.ljunggren.sanitizer.cleanser;

public class TrimCleanser implements Cleanser<String> {

    public String cleanse(String value) {
        return value == null ? value : value.trim();
    }

    public String description() {
        return "Remove leading and trailing spaces";
    }

}
