package com.gramm.ana;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AnagramFinderTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void findingAnagrams_shouldPrintEmptyArray_whenReferenceWordBlank(String referenceWord) {
        List<String> output = AnagramFinder.findAnagrams(referenceWord, new String[]{"Words", "of", "the", "world"});
        assertTrue(output.isEmpty());
    }

    @Test
    void findingAnagrams_shouldPrintEmptyArray_whenInputArrayBlank() {
        List<String> output = AnagramFinder.findAnagrams("good", new String[]{});
        assertTrue(output.isEmpty());
    }

    @Test
    void findingAnagrams_shouldPrintEmptyArray_whenBothReferenceWordAndInputArrayBlank() {
        List<String> output = AnagramFinder.findAnagrams("", new String[]{});
        assertTrue(output.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"stare","aster", "rates", "tears", "earst"})
    void findingAnagrams_shouldReturnListOfOneWord_whenInputContainsAnagrams(String referenceWord) {
        String text = "The cats stare the rat";
        String[] textArray = text.split("\\s+");

        List<String> output = AnagramFinder.findAnagrams(referenceWord, textArray);
        assertEquals(1, output.size());
        assertEquals("stare", output.stream().findFirst().get());
    }

    @ParameterizedTest
    @ValueSource(strings = {"least", "steal", "astle"})
    void findingAnagrams_shouldReturnListOfTwoWords_whenInputContainsAnagrams(String referenceWord) {
        String text = "at least that is a steal";
        String[] textArray = text.split("\\s+");

        List<String> output = AnagramFinder.findAnagrams(referenceWord, textArray);
        assertEquals(2, output.size());
        assertEquals("least", output.get(0));
        assertEquals("steal", output.get(1));
    }
}