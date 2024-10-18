package com.gramm.ana;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ReferenceWordTest {

    private ReferenceWord referenceWord;

    @ParameterizedTest
    @MethodSource("providePositiveAnagramTestCases")
    void areAnagrams_shouldReturnTrue_whenInputsAreAnagramsToEachOther(String referenceWord, String word) {
        this.referenceWord = new ReferenceWord(referenceWord);
        assertTrue(this.referenceWord.isAnagram(word));
    }

    @ParameterizedTest
    @MethodSource("provideNotAnagramTestCases")
    void areAnagrams_shouldReturnFalse_whenInputsAreNotAnagrams(String referenceWord, String word) {
        this.referenceWord = new ReferenceWord(referenceWord);
        assertFalse(this.referenceWord.isAnagram(word));
    }

    private static Stream<Arguments> providePositiveAnagramTestCases() {
        return Stream.of(
                Arguments.of("listen", "silent"),
                Arguments.of("night", "Thing"),
                Arguments.of("stressed", "desserts"),
                Arguments.of("BraG", "grab"),
                Arguments.of("save", "VASE"),
                Arguments.of("fried", "fired"),
                Arguments.of("Lager", "regal"),
                Arguments.of("Kiel", "leik"),
                Arguments.of("elbow", "below")
        );
    }

    private static Stream<Arguments> provideNotAnagramTestCases() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("Football", ""),
                Arguments.of("", "Thing"),
                Arguments.of("Tree", "Baum"),
                Arguments.of("SPECIALIZED", "TREK")
        );
    }
}