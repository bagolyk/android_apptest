package com.example.neptunname;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    NeptunChanger change = new NeptunChanger();

    @Test
    public void neptunIdchangerTest_empty() {
        assertEquals("", change.neptunIdchanger(""));
    }

    @Test
    public void neptunIdchangerTest_LetterK() {
        assertEquals("9", change.neptunIdchanger("k"));
        assertEquals("9", change.neptunIdchanger("K"));
    }

    @Test
    public void neptunIdchangerTest_LetterP() {
        assertEquals("g", change.neptunIdchanger("p"));
        assertEquals("G", change.neptunIdchanger("P"));
    }

    @Test
    public void neptunIdchangerTest_LetterL() {
        assertEquals("0", change.neptunIdchanger("l"));
        assertEquals("0", change.neptunIdchanger("L"));
    }

    @Test
    public void neptunIdchangerTest_NoChange() {
        assertEquals("0", change.neptunIdchanger("l"));
        assertEquals("0", change.neptunIdchanger("L"));
    }

    @Test
    public void neptunIdchangerTest_AllChange() {
        assertEquals("99GG00", change.neptunIdchanger("K9PGL0"));
    }

    @Test
    public void neptunIdchangerTest_MixedChange() {
        assertEquals("9cat9GcatG0dog0", change.neptunIdchanger("Kcat9PcatGLdog0"));
    }

    @Test
    public void asciiSumTest_Empty() {
        assertEquals(0, change.asciiSum(""));
    }

    @Test
    public void asciiSumTest_Numbers() {
        assertEquals(150, change.asciiSum("123"));
    }

    @Test
    public void asciiSumTest_Strings() {
        assertEquals(1201, change.asciiSum("maineCoonCat"));
    }

    @Test
    public void asciiSumTest_Mixed() {
        assertEquals(407, change.asciiSum("K9PGL0"));
    }

    @Test
    public void asciiSumTest_Symbols() {
        assertEquals(209, change.asciiSum("K-*/"));
    }
}