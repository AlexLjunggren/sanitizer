package com.ljunggren.sanitizer.cleanser;

import static org.junit.Assert.*;

import org.junit.Test;

public class UppercaseCleanserTest {

    @Test
    public void cleanseTest() {
        assertEquals("ALEX", new UppercaseCleanser().cleanse("Alex"));
        assertEquals("", new UppercaseCleanser().cleanse(""));
        assertEquals(null, new UppercaseCleanser().cleanse(null));
    }
    
    @Test
    public void descriptionTest() {
        assertEquals("Uppercase all characters", new UppercaseCleanser().description());
    }

}
