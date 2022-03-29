package io.ljunggren.sanitizer.sanitation;

import java.lang.annotation.Annotation;

import io.ljunggren.sanitizer.Item;
import io.ljunggren.sanitizer.annotation.ConcurrentSpace;
import io.ljunggren.sanitizer.cleanser.Cleanser;
import io.ljunggren.sanitizer.cleanser.ReplaceCleanser;

public class ConcurrentSpaceSanitation extends SanitationChain {
    
    private final String SPACE = " ";
    
    @Override
    public void sanitize(Annotation annotation, Item item) {
        if (annotation.annotationType() == ConcurrentSpace.class && isString(item)) {
            Cleanser<String> cleanser = new ReplaceCleanser(SPACE + SPACE, SPACE);
            item.setValue(cleanser.cleanse(item.getValue().toString()));
            return;
        }
        nextChain.sanitize(annotation, item);
    }

}
