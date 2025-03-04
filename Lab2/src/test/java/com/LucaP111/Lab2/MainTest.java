package com.LucaP111.Lab2;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void testConcatenare() {
        String rezultat = "Walk, to, store";
        assertEquals(rezultat, "Walk, to, store");
    }

    @Test
    void testStringGol() {
        String rezultat = "";
        assertEquals(rezultat, "");
    }
}