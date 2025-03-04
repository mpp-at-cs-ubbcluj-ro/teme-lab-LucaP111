package com.LucaP111.Lab2;

import com.google.common.base.Joiner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void testConcatenare() {
        String rezultat = Joiner.on(",").join("Walk" , "to" , "store");
        assertEquals(rezultat, "Walk,to,store");
    }

    @Test
    void testStringGol() {
        String rezultat = Joiner.on("").join("" , "" , "");
        assertEquals(rezultat, "");
    }
}

;
