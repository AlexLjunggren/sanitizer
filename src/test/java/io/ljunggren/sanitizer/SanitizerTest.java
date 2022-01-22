package io.ljunggren.sanitizer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.ljunggren.sanitizer.annotation.Lowercase;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class SanitizerTest {
    
    @AllArgsConstructor
    @Getter
    private class TestPojo {
        @Lowercase
        private String name;
    }

    @Test
    public void sanitizeTest() {
        TestPojo pojo = new TestPojo("Alex");
        new Sanitizer(pojo).sanitize();
        assertEquals("alex", pojo.getName());
    }

}
