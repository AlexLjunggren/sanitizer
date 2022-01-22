package io.ljunggren.sanitizer.cleanser;

public class UppercaseCleanser implements Cleanser<String> {

    public String cleanse(String value) {
        return value == null? value : value.toUpperCase();
    }

    public String description() {
        return "Uppercase all characters";
    }

}
