package io.ljunggren.sanitizer.sanitation;

import java.lang.annotation.Annotation;

import io.ljunggren.sanitizer.Item;
import io.ljunggren.sanitizer.annotation.Accent;
import io.ljunggren.sanitizer.cleanser.AccentCleanser;
import io.ljunggren.sanitizer.cleanser.Cleanser;

public class AccentSanitation extends SanitationChain {

    private Class<?> annotationClass = Accent.class;
    private Cleanser<String> cleanser = new AccentCleanser();

    @Override
    public void sanitize(Annotation annotation, Item item) {
        if (annotation.annotationType() == annotationClass && item.getValue() instanceof String) {
            item.setValue(cleanser.cleanse(item.getValue().toString()));
            return;
        }
        nextChain.sanitize(annotation, item);
    }

}
