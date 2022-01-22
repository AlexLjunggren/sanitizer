package io.ljunggren.sanitizer.sanitation;

import java.lang.annotation.Annotation;

import io.ljunggren.sanitizer.Item;
import io.ljunggren.sanitizer.annotation.Uppercase;
import io.ljunggren.sanitizer.cleanser.Cleanser;
import io.ljunggren.sanitizer.cleanser.UppercaseCleanser;

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
