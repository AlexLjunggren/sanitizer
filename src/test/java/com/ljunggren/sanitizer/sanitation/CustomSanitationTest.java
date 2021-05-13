package com.ljunggren.sanitizer.sanitation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ljunggren.sanitizer.Sanitizer;
import com.ljunggren.sanitizer.annotation.CustomSanitizer;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class CustomSanitationTest {
    
    @AllArgsConstructor
    @Getter
    private class CustomPojo {
        @CustomSanitizer(className = "com.ljunggren.sanitizer.cleanser.LowercaseCleanser")
        private String name;
    }

    @Test
    public void sanitizeTest() {
        CustomPojo pojo = new CustomPojo("ALEX");
        new Sanitizer(pojo).sanitize();
        assertEquals("alex", pojo.getName());
    }
    
    @AllArgsConstructor
    @Getter
    private class InvalidCustomPojo {
        @CustomSanitizer(className = "not.real.class")
        private String name;
    }

    @Test
    public void sanitizeInvalidClassTest() {
        InvalidCustomPojo pojo = new InvalidCustomPojo("ALEX");
        new Sanitizer(pojo).sanitize();
        assertEquals("ALEX", pojo.getName());
    }

}
