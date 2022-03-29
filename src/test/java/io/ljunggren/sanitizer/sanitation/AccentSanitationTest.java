package io.ljunggren.sanitizer.sanitation;

import static org.junit.Assert.*;

import org.junit.Test;

import io.ljunggren.sanitizer.Sanitizer;
import io.ljunggren.sanitizer.annotation.Accent;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class AccentSanitationTest {
    
    @AllArgsConstructor
    @Getter
    private class AccentPojo {
        @Accent
        private String name;
    }

    @Test
    public void sanitizeTest() {
        AccentPojo pojo = new AccentPojo("Älex");
        new Sanitizer(pojo).sanitize();
        assertEquals("Alex", pojo.getName());
    }

    @Test
    public void sanitizeNullTest() {
        AccentPojo pojo = new AccentPojo(null);
        new Sanitizer(pojo).sanitize();
        assertEquals(null, pojo.getName());
    }

}
