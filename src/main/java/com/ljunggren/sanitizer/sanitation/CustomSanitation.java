package com.ljunggren.sanitizer.sanitation;

import java.lang.annotation.Annotation;

import com.ljunggren.sanitizer.Item;
import com.ljunggren.sanitizer.annotation.CustomSanitizer;
import com.ljunggren.sanitizer.cleanser.Cleanser;

public class CustomSanitation extends SanitationChain {
    
    @Override
    public void sanitize(Annotation annotation, Item item) {
        if (annotation.annotationType() == CustomSanitizer.class) {
            String className = ((CustomSanitizer) annotation).className();
            try {
                Cleanser<Object> cleanser = instantiateCleanser(className);
                item.setValue(cleanser.cleanse(item.getValue().toString()));
            } catch (Exception e) {
                // do something with exception
            }
            return;
        }
        nextChain.sanitize(annotation, item);
    }

    @SuppressWarnings("unchecked")
    private Cleanser<Object> instantiateCleanser(String className) throws Exception {
        try {
            Class<?> clazz = Class.forName(className);
            if (Cleanser.class.isAssignableFrom(clazz)) {
                return (Cleanser<Object>) clazz.newInstance();
            }
            throw new Exception("CustomSanitizer className does not implement Cleanser");
        } catch (ClassNotFoundException e) {
            throw new Exception("CustomSanitizer class not found " + e.getMessage());
        }
    }
    
}
