package com.infoshareacademy.zieloni.utils;

import org.junit.*;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
public class FormatTimeTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Rozpoczęcie testów before class");
    }

    @AfterClass
    public static void afterClass()
    {
        System.out.println("Testy zakończone after class");
    }

    @Before
    public void before() {

        System.out.println("before przed każdym testem");
    }

    @After
    public void after() {

        System.out.println("after po każdym tescie");
        System.out.println("______________________");
    }

   @Test
    public void formatTime_test0() throws Exception {
        System.out.println("test0");
        String result = FormatTime.dateFromTo("27:00+74");
        assertEquals("04:14", result);
    }

    @Test
    public void  formatTime_test1() throws Exception {
        System.out.println("test1");
        String result = FormatTime.dateFromTo("27:90+74");
        assertEquals("05:44", result);
    }

    @Test
    public void  formatTime_test2() throws Exception {
        System.out.println("test2");
        String result = FormatTime.dateFromTo("24:00+0");
        assertEquals("00:00", result);
    }


   /* @Test
    public void  formatTime_test3() throws Exception {
        System.out.println("test3");
        String result = FormatTime.dateFromTo("48:00 + 0");
        assertEquals("00:00", result);

    }*/

    @Test
    public void  formatTime_test3() throws Exception {
        System.out.println("test3");
        String result = FormatTime.dateFromTo("08:00+10");
       assertThat(result).contains("08:10");

    }

    @Test
    public void  formatTime_test4() throws Exception {
        System.out.println("test3");
        String result = FormatTime.dateFromTo("00:00+1440");
        assertThat(result).contains("00:00");

    }
}