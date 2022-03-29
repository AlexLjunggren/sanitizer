package io.ljunggren.sanitizer.sanitation;

import java.lang.annotation.Annotation;

import io.ljunggren.sanitizer.Item;
import io.ljunggren.sanitizer.annotation.Lowercase;
import io.ljunggren.sanitizer.cleanser.Cleanser;
import io.ljunggren.sanitizer.cleanser.LowercaseCleanser;

public class LowercaseSanitation extends SanitationChain {
    
    private Class<?> annotationClass = Lowercase.class;
    private Cleanser<String> cleanser = new LowercaseCleanser();

    @Override
    public void sanitize(Annotation annotation, Item item) {
        if (annotation.annotationType() == annotationClass && isString(item)) {
            item.setValue(cleanser.cleanse(item.getValue().toString()));
            return;
        }
        nextChain.sanitize(annotation, item);
    }

}
