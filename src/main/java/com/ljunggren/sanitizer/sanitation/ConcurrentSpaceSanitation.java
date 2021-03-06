package com.ljunggren.sanitizer.sanitation;

import java.lang.annotation.Annotation;

import com.ljunggren.sanitizer.Item;
import com.ljunggren.sanitizer.annotation.ConcurrentSpace;
import com.ljunggren.sanitizer.cleanser.Cleanser;
import com.ljunggren.sanitizer.cleanser.ReplaceCleanser;

public class ConcurrentSpaceSanitation extends SanitationChain {
    
    private final String SPACE = " ";
    
    @Override
    public void sanitize(Annotation annotation, Item item) {
        if (annotation.annotationType() == ConcurrentSpace.class && item.getValue() instanceof String) {
            Cleanser<String> cleanser = new ReplaceCleanser(SPACE + SPACE, SPACE);
            item.setValue(cleanser.cleanse(item.getValue().toString()));
            return;
        }
        nextChain.sanitize(annotation, item);
    }

}
