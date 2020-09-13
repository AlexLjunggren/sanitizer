package com.ljunggren.sanitizer.sanitation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ljunggren.sanitizer.Sanitizer;
import com.ljunggren.sanitizer.annotation.ConcurrentSpaceSanitation;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ConcurrentSpaceSanitationChainTest {
    
    @AllArgsConstructor
    @Getter
    private class ConcurrentPojo {
        @ConcurrentSpaceSanitation
        private String address;
    }

    @Test
    public void sanitizeTest() {
        ConcurrentPojo pojo = new ConcurrentPojo("10  First    St.");
        new Sanitizer(pojo).sanitize();
        assertEquals("10 First St.", pojo.getAddress());
    }

}
