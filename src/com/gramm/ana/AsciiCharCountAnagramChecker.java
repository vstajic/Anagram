package com.gramm.ana;

public class AsciiCharCountAnagramChecker implements AnagramChecker {

    public boolean areAnagrams(String referenceWord, String word) {

        if (referenceWord.isEmpty() || word.isEmpty()) {
            return false;
        }

        referenceWord = referenceWord.replaceAll("\\s", "").toLowerCase();
        word = word.replaceAll("\\s", "").toLowerCase();

        int[] asciiCharsCount = new int[256];

        if (referenceWord.length() != word.length()) {
            return false;
        }

        for (int i = 0; i < referenceWord.length(); i++) {
            if (!Character.isAlphabetic(referenceWord.charAt(i)) || !Character.isAlphabetic(word.charAt(i))) {
                throw new IllegalArgumentException(
                        "Input contains non alphabetic character. *Those are not tolerated over here!");
            }
            asciiCharsCount[referenceWord.charAt(i)]++;
            asciiCharsCount[word.charAt(i)]--;
        }

        for (int asciiCharCount : asciiCharsCount) {
            if (asciiCharCount != 0) {
                return false;
            }
        }

        return true;
    }
}
