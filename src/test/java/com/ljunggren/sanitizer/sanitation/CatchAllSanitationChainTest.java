package com.ljunggren.sanitizer.sanitation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ljunggren.sanitizer.Sanitizer;
import com.ljunggren.sanitizer.annotation.LowercaseSanitation;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class CatchAllSanitationChainTest {
    
    @AllArgsConstructor
    @Getter
    private class Pojo {
        @LowercaseSanitation
        private int number;
    }

    @Test
    public void test() {
        Pojo pojo = new Pojo(1234);
        new Sanitizer(pojo).sanitize();
        assertEquals(1234, pojo.getNumber());
    }

}
