package com.ljunggren.sanitizer.sanitation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ljunggren.sanitizer.Sanitizer;
import com.ljunggren.sanitizer.annotation.UppercaseSanitation;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class UppercaseSanitationChainTest {

    @AllArgsConstructor
    @Getter
    private class UppercasePojo {
        @UppercaseSanitation
        private String name;
    }

    @Test
    public void sanitzeTest() {
        UppercasePojo pojo = new UppercasePojo("Alex");
        new Sanitizer(pojo).sanitize();
        assertEquals("ALEX", pojo.getName());
    }
    
    @Test
    public void sanitzeNullTest() {
        UppercasePojo pojo = new UppercasePojo(null);
        new Sanitizer(pojo).sanitize();
        assertEquals(null, pojo.getName());
    }

}
