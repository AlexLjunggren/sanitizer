package com.ljunggren.sanitizer.cleanser;

import static org.junit.Assert.*;

import org.junit.Test;

public class LowercaseCleanserTest {

    @Test
    public void cleanseTest() {
        assertEquals("alex", new LowercaseCleanser().cleanse("Alex"));
        assertEquals("", new LowercaseCleanser().cleanse(""));
        assertEquals(null, new LowercaseCleanser().cleanse(null));
    }
    
    @Test
    public void descriptionTest() {
        assertEquals("Lowercase all characters", new LowercaseCleanser().description());
    }

}
