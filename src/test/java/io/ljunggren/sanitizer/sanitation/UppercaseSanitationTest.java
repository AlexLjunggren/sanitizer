package io.ljunggren.sanitizer.sanitation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.ljunggren.sanitizer.Sanitizer;
import io.ljunggren.sanitizer.annotation.Uppercase;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class UppercaseSanitationTest {

    @AllArgsConstructor
    @Getter
    private class UppercasePojo {
        @Uppercase
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
