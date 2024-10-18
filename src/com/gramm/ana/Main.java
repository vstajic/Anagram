package com.gramm.ana;

import java.util.*;

public final class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter reference word");
        final String referenceWord = scanner.nextLine();

        System.out.println("Enter words to check if anagram to the reference line. Delimit with empty space.");

        String line = scanner.nextLine();

        if (line.isEmpty()) {
            System.out.println("Nothing entered... Exiting program");
            return;
        }

        final String[] words = line.split("\\s+");

        List<String> anagrams = AnagramFinder.findAnagrams(referenceWord, words);

        String output = buildOutput(anagrams);
        System.out.println(output);
    }

    private static String buildOutput(List<String> anagrams) {
        StringBuilder output = new StringBuilder("[");
        for (String anagram : anagrams) {
            output.append(anagram);
            output.append(", ");
        }

        output.delete(output.length() - 2, output.length());
        output.append("]");

        return output.toString();
    }
}