package io.ljunggren.sanitizer.sanitation;

import java.lang.annotation.Annotation;

import io.ljunggren.sanitizer.Item;
import io.ljunggren.sanitizer.annotation.CustomSanitizer;
import io.ljunggren.sanitizer.cleanser.Cleanser;

public class CustomSanitation extends SanitationChain {
    
    @Override
    public void sanitize(Annotation annotation, Item item) {
        if (annotation.annotationType() == CustomSanitizer.class) {
            Class<?> clazz = ((CustomSanitizer) annotation).value();
            try {
                Cleanser<Object> cleanser = instantiateCleanser(clazz);
                item.setValue(cleanser.cleanse(item.getValue()));
            } catch (Exception e) {
                // do something with exception
            }
            return;
        }
        nextChain.sanitize(annotation, item);
    }

    @SuppressWarnings("unchecked")
    private Cleanser<Object> instantiateCleanser(Class<?> clazz) throws Exception {
        try {
            if (Cleanser.class.isAssignableFrom(clazz)) {
                return (Cleanser<Object>) clazz.newInstance();
            }
            throw new Exception(String.format("CustomSanitizer(%s) does not implement Cleanser", clazz.getSimpleName()));
        } catch (ClassNotFoundException e) {
            throw new Exception("CustomSanitizer class not found " + e.getMessage());
        }
    }
    
}
