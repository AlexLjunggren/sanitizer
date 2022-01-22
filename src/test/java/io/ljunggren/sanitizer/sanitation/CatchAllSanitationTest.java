package io.ljunggren.sanitizer.sanitation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.ljunggren.sanitizer.Sanitizer;
import io.ljunggren.sanitizer.annotation.Lowercase;
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
    public void sanitizeTest() {
        Pojo pojo = new Pojo(1234);
        new Sanitizer(pojo).sanitize();
        assertEquals(1234, pojo.getNumber());
    }

}
