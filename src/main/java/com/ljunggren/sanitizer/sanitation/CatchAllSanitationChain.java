package com.ljunggren.sanitizer.sanitation;

import java.lang.annotation.Annotation;

import com.ljunggren.sanitizer.Item;

public class CatchAllSanitationChain extends SanitationChain {

    @Override
    public void sanitize(Annotation annotation, Item item) {
        return;
    }

}
