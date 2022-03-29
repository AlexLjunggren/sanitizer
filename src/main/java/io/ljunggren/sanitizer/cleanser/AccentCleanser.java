package io.ljunggren.sanitizer.cleanser;

import org.apache.commons.lang3.StringUtils;

public class AccentCleanser implements Cleanser<String> {

    @Override
    public String cleanse(String value) {
        return value == null ? value : StringUtils.stripAccents(value);
    }

    @Override
    public String description() {
        return "Strip accents from characters";
    }

}
