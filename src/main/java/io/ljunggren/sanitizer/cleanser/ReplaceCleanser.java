package io.ljunggren.sanitizer.cleanser;

public class ReplaceCleanser implements Cleanser<String> {

    private String replacer;
    private String replacement;

    public ReplaceCleanser(String replacer, String replacement) {
        this.replacer = replacer;
        this.replacement = replacement;
    }

    @Override
    public String cleanse(String value) {
        if (value == null || replacer == null || replacement == null) {
            return value;
        }
        return replace(value);
    }
    
    private String replace(String value) {
        if (value.contains(replacer)) {
            return replace(value.replace(replacer, replacement));
        }
        return value;
    }

    @Override
    public String description() {
        return String.format("Replace '%s' with '%s'", replacer, replacement);
    }

}
