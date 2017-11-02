package com.infoshareacademy.zieloni.Utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class FormatTimeTest {
    @Test
    public void test0() throws Exception {
        String result = FormatTime.dateFromTo("27:00 + 74");
        assertEquals("04:14", result);
    }

    @Test
    public void test1() throws Exception {
        String result = FormatTime.dateFromTo("27:90 + 74");
        assertEquals("05:44", result);
    }

    @Test
    public void test2() throws Exception {
        String result = FormatTime.dateFromTo("24:00 + 0");
        assertEquals("00:00", result);
    }
}