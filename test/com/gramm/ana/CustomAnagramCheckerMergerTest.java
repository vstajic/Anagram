package com.gramm.ana;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CustomAnagramCheckerMergerTest {

    CustomWordMerger wordMerger = new CustomWordMerger();

    @Test
    void buildOutput_printsOpenAndCloseBracket_atTheBeginningAndEndOfOutput() {
        String output = wordMerger.buildOutput(List.of("some", "words"));

        assertEquals('[', output.charAt(0));
        assertEquals(']', output.charAt(output.length() - 1));
    }

    @Test
    void buildOutput_returnsEmptyString_whenInputEmptyList() {
        String output = wordMerger.buildOutput(new ArrayList<>());

        assertEquals(2, output.length());
        assertEquals('[', output.charAt(0));
        assertEquals(']', output.charAt(output.length() - 1));
    }

    @Test
    void buildOutput_returnsStringContainingAllWordsFromInputAndOnlyThoseWordsDelimitedByComma_whenInputNonEmpty() {
        String output = wordMerger.buildOutput(List.of("some", "words"));

        assertTrue(output.contains("some"));
        assertTrue(output.contains(", "));
        assertFalse(output.contains("other"));
        assertTrue(output.contains("words"));
    }

}