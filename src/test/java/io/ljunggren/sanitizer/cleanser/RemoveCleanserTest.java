package io.ljunggren.sanitizer.cleanser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RemoveCleanserTest {

    @Test
    public void cleanseTest() {
        assertEquals("Alex", new RemoveCleanser(" ").cleanse(" A le x "));
        assertEquals("Prograing", new RemoveCleanser("mm").cleanse("Programming"));
        assertEquals("Programming", new RemoveCleanser(null).cleanse("Programming"));
        assertEquals(null, new RemoveCleanser("mm").cleanse(null));
    }
    
    @Test
    public void descriptionTest() {
        assertEquals("Remove all mm", new RemoveCleanser("mm").description());
    }

}
