package com.example.Junit_Mockito.coreJava;

import java.util.HashMap;
import java.util.Map;

public class MaxMinCharacter {

    public static void main(String[] args) {
        String str = "Hello World";

        char maxChar = findMaxChar(str);
        char minChar = findMinChar(str);

        System.out.println("Maximum occurring character: " + maxChar);
        System.out.println("Minimum occurring character: " + minChar);
    }

    private static char findMaxChar(String str) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : str.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        char maxChar = ' ';
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxChar = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return maxChar;
    }

    private static char findMinChar(String str) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : str.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        char minChar = ' ';
        int minCount = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() < minCount) {
                minChar = entry.getKey();
                minCount = entry.getValue();
            }
        }

        return minChar;
    }
}