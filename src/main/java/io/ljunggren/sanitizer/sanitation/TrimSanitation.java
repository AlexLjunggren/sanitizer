package io.ljunggren.sanitizer.sanitation;

import java.lang.annotation.Annotation;

import io.ljunggren.sanitizer.Item;
import io.ljunggren.sanitizer.annotation.Trim;
import io.ljunggren.sanitizer.cleanser.Cleanser;
import io.ljunggren.sanitizer.cleanser.TrimCleanser;

public class TrimSanitation extends SanitationChain {
    
    private Class<?> annotationClass = Trim.class;
    private Cleanser<String> cleanser = new TrimCleanser();

    @Override
    public void sanitize(Annotation annotation, Item item) {
        if (annotation.annotationType() == annotationClass && item.getValue() instanceof String) {
            item.setValue(cleanser.cleanse(item.getValue().toString()));
            return;
        }
        nextChain.sanitize(annotation, item);
    }

}
