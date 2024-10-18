package com.gramm.ana;

public class ReferenceWord implements Word {

    private String referenceWord;

    public ReferenceWord(String referenceWord) {
        this.referenceWord = referenceWord;
    }

    public boolean isAnagram(String word) {

        if (referenceWord.isEmpty() || word.isEmpty()) {
            return false;
        }

        if (referenceWord.length() != word.length()) {
            return false;
        }

        referenceWord = referenceWord.replaceAll("\\s", "").toLowerCase();
        word = word.replaceAll("\\s", "").toLowerCase();

        int[] asciiCharsCount = new int[256];

        for (int i = 0; i < this.referenceWord.length(); i++) {
            asciiCharsCount[this.referenceWord.charAt(i)]++;
            asciiCharsCount[word.charAt(i)]--;
        }

        for (int j : asciiCharsCount) {
            if (j != 0) {
                return false;
            }
        }

        return true;
    }



}
