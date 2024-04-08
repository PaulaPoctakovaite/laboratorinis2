package com.example.laboratorinis2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testCountWordsNoText() {
        Calculations calc = new Calculations();
        assertEquals(0, calc.CountWords(""));
    }

    @Test
    public void testCountWordsBasicText() {
        Calculations calc = new Calculations();
        assertEquals(2, calc.CountWords("Hello World"));
    }

    @Test
    public void testCountWordsWhitespace() {
        Calculations calc = new Calculations();
        assertEquals(0, calc.CountWords("     "));
    }

    @Test
    public void testCountSymbolsNoText() {
        Calculations calc = new Calculations();
        assertEquals(0, calc.CountSymbols(""));
    }

    @Test
    public void testCountSymbolsBasicText() {
        Calculations calc = new Calculations();
        assertEquals(11, calc.CountSymbols("Hello World"));
    }

    @Test
    public void testCountSymbolsWhitespace() {
        Calculations calc = new Calculations();
        assertEquals(5, calc.CountSymbols("     "));
    }
}