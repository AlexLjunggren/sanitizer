package com.ljunggren.sanitizer.sanitation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ljunggren.sanitizer.Sanitizer;
import com.ljunggren.sanitizer.annotation.Lowercase;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class LowercaseSanitationTest {
    
    @AllArgsConstructor
    @Getter
    private class LowercasePojo {
        @Lowercase
        private String name;
    }

    @Test
    public void sanitzeTest() {
        LowercasePojo pojo = new LowercasePojo("Alex");
        new Sanitizer(pojo).sanitize();
        assertEquals("alex", pojo.getName());
    }
    
    @Test
    public void sanitzeNullTest() {
        LowercasePojo pojo = new LowercasePojo(null);
        new Sanitizer(pojo).sanitize();
        assertEquals(null, pojo.getName());
    }

}
