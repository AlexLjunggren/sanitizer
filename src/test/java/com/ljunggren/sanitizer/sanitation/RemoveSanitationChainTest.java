package com.ljunggren.sanitizer.sanitation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ljunggren.sanitizer.Sanitizer;
import com.ljunggren.sanitizer.annotation.RemoveSanitation;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class RemoveSanitationChainTest {
    
    @AllArgsConstructor
    @Getter
    private class RemovePojo {
        @RemoveSanitation(toRemove = "-")
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
