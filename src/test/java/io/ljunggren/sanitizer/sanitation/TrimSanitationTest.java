package io.ljunggren.sanitizer.sanitation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.ljunggren.sanitizer.Sanitizer;
import io.ljunggren.sanitizer.annotation.Trim;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class TrimSanitationTest {
    
    @AllArgsConstructor
    @Getter
    private class TrimPojo {
        @Trim
        private String name;
    }

    @Test
    public void sanitzeTest() {
        TrimPojo pojo = new TrimPojo("  Alex   ");
        new Sanitizer(pojo).sanitize();
        assertEquals("Alex", pojo.getName());
    }
    
    @Test
    public void sanitzeNullTest() {
        TrimPojo pojo = new TrimPojo(null);
        new Sanitizer(pojo).sanitize();
        assertEquals(null, pojo.getName());
    }

}
