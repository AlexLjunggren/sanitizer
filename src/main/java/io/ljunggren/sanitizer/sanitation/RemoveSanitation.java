package io.ljunggren.sanitizer.sanitation;

import java.lang.annotation.Annotation;

import io.ljunggren.sanitizer.Item;
import io.ljunggren.sanitizer.annotation.Remove;
import io.ljunggren.sanitizer.cleanser.Cleanser;
import io.ljunggren.sanitizer.cleanser.RemoveCleanser;

public class RemoveSanitation extends SanitationChain {
    
    @Override
    public void sanitize(Annotation annotation, Item item) {
        if (annotation.annotationType() == Remove.class && item.getValue() instanceof String) {
            String toRemove = ((Remove) annotation).value();
            Cleanser<String> cleanser = new RemoveCleanser(toRemove);
            item.setValue(cleanser.cleanse(item.getValue().toString()));
            return;
        }
        nextChain.sanitize(annotation, item);
    }

}
