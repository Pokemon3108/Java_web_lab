package com.project1.web1.service;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class StringDescriptionServiceTest {

    @Test
    public void testIsPolyndrom() {
        StringDescriptionService service = new StringDescriptionService();
        String checkedString = "gog";
        String expectedString = "Да";
        assertEquals(service.isPolyndrom(checkedString), expectedString);
    }

    @Test
    public void testStringLength() {
        StringDescriptionService service = new StringDescriptionService();
        String checkedString = "gog";
        int len = 3;
        assertEquals(len, service.StringLength(checkedString));
    }

    @Test
    public void testNotPolyndrom() {
        StringDescriptionService service = new StringDescriptionService();
        String checkedString = "cat";
        String expectedString = "Нет";
        assertEquals(service.isPolyndrom(checkedString), expectedString);
    }
}