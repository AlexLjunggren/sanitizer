package com.ljunggren.sanitizer;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ljunggren.sanitizer.annotation.LowercaseSanitation;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class SanitizerTest {
    
    @AllArgsConstructor
    @Getter
    private class TestPojo {
        @LowercaseSanitation
        private String name;
    }

    @Test
    public void validateTest() {
        TestPojo pojo = new TestPojo("Alex");
        new Sanitizer(pojo).sanitize();
        assertEquals("alex", pojo.getName());
    }

}
