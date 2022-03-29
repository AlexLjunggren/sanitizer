package io.ljunggren.sanitizer.cleanser;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccentCleanserTest {

    @Test
    public void cleanseTest() {
        assertEquals("alex", new AccentCleanser().cleanse("álex"));
        assertEquals("Alex", new AccentCleanser().cleanse("Älex"));
        assertEquals("", new AccentCleanser().cleanse(""));
        assertEquals(null, new AccentCleanser().cleanse(null));
    }
    
    @Test
    public void descriptionTest() {
        assertEquals("Strip accents from characters", new AccentCleanser().description());
    }

}
