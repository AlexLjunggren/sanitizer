package io.ljunggren.sanitizer.sanitation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.ljunggren.sanitizer.Sanitizer;
import io.ljunggren.sanitizer.annotation.Remove;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class RemoveSanitationTest {
    
    @AllArgsConstructor
    @Getter
    private class RemovePojo {
        @Remove("-")
        private String phone;
    }

    @Test
    public void sanitizeTest() {
        RemovePojo pojo = new RemovePojo("867-5309");
        new Sanitizer(pojo).sanitize();
        assertEquals("8675309", pojo.getPhone());
    }
    
    @Test
    public void sanitizeNullTest() {
        RemovePojo pojo = new RemovePojo(null);
        new Sanitizer(pojo).sanitize();
        assertEquals(null, pojo.getPhone());
    }

}
