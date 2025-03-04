package com.LucaP111.Lab2;

import com.google.common.base.Splitter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void testSplitString() {
        List<String> rezultat = Splitter.on(",").splitToList("Walk,to,store");
        assertEquals(List.of("Walk", "to", "store"), rezultat);
    }

    @Test
    void testSplitStringWithEmptyElements() {
        List<String> rezultat = Splitter.on(",").omitEmptyStrings().splitToList("Walk,,to,store");
        assertEquals(List.of("Walk", "to", "store"), rezultat);
    }
}