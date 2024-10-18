package com.gramm.ana;

import java.util.*;

public final class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a reference word:");
        final String referenceWord = scanner.nextLine();

        System.out.println("Enter words to check if anagram to the reference line. Delimit with empty space.");

        String line = scanner.nextLine();

        if (line.isEmpty()) {
            System.out.println("Nothing entered... Exiting program");
            return;
        }

        final String[] words = line.split("\\s+");

        List<String> anagrams = TextProcessor.findAnagrams(referenceWord, words);

        OutputBuilder wordMerger = new CustomWordMerger();

        String output = wordMerger.buildOutput(anagrams);
        System.out.println(output);
    }
}