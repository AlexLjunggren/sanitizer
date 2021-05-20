package com.ljunggren.sanitizer.sanitation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ljunggren.sanitizer.Sanitizer;
import com.ljunggren.sanitizer.annotation.CustomSanitizer;
import com.ljunggren.sanitizer.cleanser.LowercaseCleanser;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class CustomSanitationTest {
    
    @AllArgsConstructor
    @Getter
    private class CustomPojo {
        @CustomSanitizer(LowercaseCleanser.class)
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
    private class NonEvaluationPojo {
        @CustomSanitizer(String.class)
        private String name;
    }

    @Test
    public void sanitizeInvalidClassTest() {
        NonEvaluationPojo pojo = new NonEvaluationPojo("ALEX");
        new Sanitizer(pojo).sanitize();
        assertEquals("ALEX", pojo.getName());
    }

}
