package com.ljunggren.sanitizer.sanitation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ljunggren.sanitizer.Sanitizer;
import com.ljunggren.sanitizer.annotation.TrimSanitation;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class TrimSanitationChainTest {
    
    @AllArgsConstructor
    @Getter
    private class TrimPojo {
        @TrimSanitation
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
