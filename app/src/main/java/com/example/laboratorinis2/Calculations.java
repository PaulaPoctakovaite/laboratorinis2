package com.example.laboratorinis2;

public class Calculations {

    public int CountWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        String[] words = text.split("\\s+");
        return words.length;
    }

    public int CountSymbols(String text) {
        return text.length();
    }
}
