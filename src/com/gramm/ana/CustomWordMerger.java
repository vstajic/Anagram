package com.gramm.ana;

import java.util.*;

public class CustomWordMerger implements OutputBuilder {

    @Override
    public String buildOutput(List<String> anagrams) {
        StringBuilder output = new StringBuilder("[");
        for (String anagram : anagrams) {
            output.append(anagram);
            output.append(", ");
        }

        if (!anagrams.isEmpty()) {
            output.delete(output.length() - 2, output.length());
        }
        output.append("]");

        return output.toString();
    }
}
