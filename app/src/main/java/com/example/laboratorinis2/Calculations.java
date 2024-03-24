package com.example.laboratorinis2;

public class Calculations {

    public int CountWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

    public int CountSymbols(String text) {
        return text.length();
    }
}
