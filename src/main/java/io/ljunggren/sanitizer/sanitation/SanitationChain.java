package io.ljunggren.sanitizer.sanitation;

import java.lang.annotation.Annotation;

import io.ljunggren.sanitizer.Item;

public abstract class SanitationChain {

    protected SanitationChain nextChain;
    
    public SanitationChain nextChain(SanitationChain nextChain) {
        this.nextChain = nextChain;
        return this;
    }
    
    public abstract void sanitize(Annotation annotation, Item item);
    
    protected boolean isString(Item item) {
        return item.getValue() instanceof String;
    }
    
}
