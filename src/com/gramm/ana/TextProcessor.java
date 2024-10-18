package com.gramm.ana;

import java.util.*;

public class TextProcessor {

    public static List<String> findAnagrams(String referenceWord, String[] words) {
        if (referenceWord.isBlank()) {
            return Collections.emptyList();
        }

        if (words.length == 0) {
            return Collections.emptyList();
        }

        List<String> anagrams = new ArrayList<>();

        AnagramChecker anagramChecker = new AsciiCharCountAnagramChecker();

        for (String word : words) {
            final String purgedWord = word
                    .replaceAll("[a-zA-Z]]", "")
                    .replaceAll("\\s", "")
                    .toLowerCase();;
            if (anagramChecker.areAnagrams(referenceWord, purgedWord)) {
                anagrams.add(purgedWord);
            }
        }

        return anagrams;
    }
}
