package com.ljunggren.sanitizer.sanitation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ljunggren.sanitizer.Sanitizer;
import com.ljunggren.sanitizer.annotation.Lowercase;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class CatchAllSanitationTest {
    
    @AllArgsConstructor
    @Getter
    private class Pojo {
        @Lowercase
        private int number;
    }

    @Test
    public void test() {
        Pojo pojo = new Pojo(1234);
        new Sanitizer(pojo).sanitize();
        assertEquals(1234, pojo.getNumber());
    }

}
