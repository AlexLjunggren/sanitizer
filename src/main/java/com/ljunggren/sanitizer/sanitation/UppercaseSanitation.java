package com.ljunggren.sanitizer.sanitation;

import java.lang.annotation.Annotation;

import com.ljunggren.sanitizer.Item;
import com.ljunggren.sanitizer.annotation.Uppercase;
import com.ljunggren.sanitizer.cleanser.Cleanser;
import com.ljunggren.sanitizer.cleanser.UppercaseCleanser;

public class UppercaseSanitation extends SanitationChain {
    
    private Class<?> annotationClass = Uppercase.class;
    private Cleanser<String> cleanser = new UppercaseCleanser();

    @Override
    public void sanitize(Annotation annotation, Item item) {
        if (annotation.annotationType() == annotationClass && item.getValue() instanceof String) {
            item.setValue(cleanser.cleanse(item.getValue().toString()));
            return;
        }
        nextChain.sanitize(annotation, item);
    }

}
