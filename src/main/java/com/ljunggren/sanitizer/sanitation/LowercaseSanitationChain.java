package com.ljunggren.sanitizer.sanitation;

import java.lang.annotation.Annotation;

import com.ljunggren.sanitizer.Item;
import com.ljunggren.sanitizer.annotation.LowercaseSanitation;
import com.ljunggren.sanitizer.cleanser.Cleanser;
import com.ljunggren.sanitizer.cleanser.LowercaseCleanser;

public class LowercaseSanitationChain extends SanitationChain {
    
    private Class<?> annotationClass = LowercaseSanitation.class;
    private Cleanser<String> cleanser = new LowercaseCleanser();

    @Override
    public void sanitize(Annotation annotation, Item item) {
        if (annotation.annotationType() == annotationClass && item.getValue() instanceof String) {
            item.setValue(cleanser.cleanse(item.getValue().toString()));
            return;
        }
        nextChain.sanitize(annotation, item);
    }

}
