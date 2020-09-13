package com.ljunggren.sanitizer.cleanser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TrimCleanserTest {
    
    @Test
    public void cleanseTest() {
        assertEquals("Alex", new TrimCleanser().cleanse("  Alex  "));
        assertEquals("", new TrimCleanser().cleanse("    "));
        assertEquals(null, new TrimCleanser().cleanse(null));
    }
    
    @Test
    public void descriptionTest() {
        assertEquals("Remove leading and trailing spaces", new TrimCleanser().description());
    }

}
