package io.ljunggren.sanitizer.cleanser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReplaceCleanserTest {

    @Test
    public void cleanseTest() {
        assertEquals("Item1, Item2, Item3", new ReplaceCleanser("|", ", ").cleanse("Item1|Item2|Item3"));
        assertEquals("Item1|Item2", new ReplaceCleanser(null, ", ").cleanse("Item1|Item2"));
        assertEquals("Item1|Item2", new ReplaceCleanser("|", null).cleanse("Item1|Item2"));
        assertEquals(null, new ReplaceCleanser("|", ", ").cleanse(null));
    }

    @Test
    public void cleanseRecurssiveTest() {
        assertEquals("10 Main St", new ReplaceCleanser("  ", " ").cleanse("10  Main   St"));
        assertEquals("a|b", new ReplaceCleanser("||", "|").cleanse("a||||||||b"));
    }
    
    @Test
    public void descriptionTest() {
        assertEquals("Replace '|' with ', '", new ReplaceCleanser("|", ", ").description());
    }

}
