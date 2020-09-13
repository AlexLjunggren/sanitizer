package com.ljunggren.sanitizer.cleanser;

public class RemoveCleanser implements Cleanser<String> {

    private String toRemove;
    
    public RemoveCleanser(String toRemove) {
        this.toRemove = toRemove;
    }

    public String cleanse(String value) {
        if (value == null || toRemove == null) {
            return value;
        }
        return value.replace(toRemove, "");
    }

    public String description() {
        return String.format("Remove all %s", toRemove);
    }

}
