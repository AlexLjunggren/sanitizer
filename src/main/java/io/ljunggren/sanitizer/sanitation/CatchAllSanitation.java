package io.ljunggren.sanitizer.sanitation;

import java.lang.annotation.Annotation;

import io.ljunggren.sanitizer.Item;

public class CatchAllSanitation extends SanitationChain {

    @Override
    public void sanitize(Annotation annotation, Item item) {
        return;
    }

}
