package com.gramm.ana;

import java.util.*;

public class AnagramFinder {

    public static List<String> findAnagrams(String referenceWord, String[] words) {
        if (referenceWord.isBlank()) {
            return Collections.emptyList();
        }

        if (words.length == 0) {
            return Collections.emptyList();
        }

        List<String> anagrams = new ArrayList<>();

        Word word = new ReferenceWord(referenceWord);

        for (String currentWord : words) {
            if (word.isAnagram(currentWord)) {
                anagrams.add(currentWord);
            }
        }
        return anagrams;
    }
}
