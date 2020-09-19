package com.ljunggren.sanitizer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.reflect.FieldUtils;

import com.ljunggren.sanitizer.sanitation.CatchAllSanitation;
import com.ljunggren.sanitizer.sanitation.ConcurrentSpaceSanitation;
import com.ljunggren.sanitizer.sanitation.LowercaseSanitation;
import com.ljunggren.sanitizer.sanitation.RemoveSanitation;
import com.ljunggren.sanitizer.sanitation.TrimSanitation;
import com.ljunggren.sanitizer.sanitation.UppercaseSanitation;

import lombok.Getter;

@Getter
public class Sanitizer {

    private Object object;

    public Sanitizer(Object object) {
        this.object = object;
    }
    
    public Sanitizer sanitize() {
        List<Item> items = findItems(object);
        sanitizeItems(items);
        return this;
    }
    
    private List<Item> findItems(Object object) {
        List<Item> items = new ArrayList<Item>();
        List<Field> fields = findObjectFields(object);
        for (Field field : fields) {
            try {
                Object value = FieldUtils.readField(field, object, true);
                items.add(new Item(object, field, value));
            } catch (IllegalAccessException e) {
                // TODO: Add something here
            }
        }
        return items;
    }
    
    private List<Field> findObjectFields(Object object) {
        if (object != null) {
            Class<?> clazz = object.getClass();
            Field[] fields = FieldUtils.getAllFields(clazz);
            return Arrays.asList(fields);
        }
        return new ArrayList<Field>();
    }
    
    private void sanitizeItems(List<Item> items) {
        items.stream().forEach(item -> sanitizeItem(item));
    }
    
    private void sanitizeItem(Item item) {
        Annotation[] annotations = item.getField().getAnnotations();
        Arrays.asList(annotations).forEach(annotation -> sanitationChain(annotation, item));
    }
    
    private void sanitationChain(Annotation annotation, Item item) {
        new ConcurrentSpaceSanitation()
                .nextChain(new LowercaseSanitation()
                .nextChain(new RemoveSanitation()
                .nextChain(new TrimSanitation()
                .nextChain(new UppercaseSanitation()
                .nextChain(new CatchAllSanitation()
                        ))))).sanitize(annotation, item);
    }

}
