package com.ljunggren.sanitizer.sanitation;

import java.lang.annotation.Annotation;

import com.ljunggren.sanitizer.Item;
import com.ljunggren.sanitizer.annotation.RemoveSanitation;
import com.ljunggren.sanitizer.cleanser.Cleanser;
import com.ljunggren.sanitizer.cleanser.RemoveCleanser;

public class RemoveSanitationChain extends SanitationChain {
    
    @Override
    public void sanitize(Annotation annotation, Item item) {
        if (annotation.annotationType() == RemoveSanitation.class && item.getValue() instanceof String) {
            String toRemove = ((RemoveSanitation) annotation).toRemove();
            Cleanser<String> cleanser = new RemoveCleanser(toRemove);
            item.setValue(cleanser.cleanse(item.getValue().toString()));
            return;
        }
        nextChain.sanitize(annotation, item);
    }

}
