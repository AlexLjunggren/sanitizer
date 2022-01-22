package io.ljunggren.sanitizer.sanitation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.ljunggren.sanitizer.Sanitizer;
import io.ljunggren.sanitizer.annotation.ConcurrentSpace;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class ConcurrentSpaceSanitationTest {
    
    @AllArgsConstructor
    @Getter
    private class ConcurrentPojo {
        @ConcurrentSpace
        private String address;
    }

    @Test
    public void sanitizeTest() {
        ConcurrentPojo pojo = new ConcurrentPojo("10  First    St.");
        new Sanitizer(pojo).sanitize();
        assertEquals("10 First St.", pojo.getAddress());
    }

}
