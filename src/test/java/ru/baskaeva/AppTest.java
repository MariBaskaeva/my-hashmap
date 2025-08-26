package ru.baskaeva;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class AppTest {
    @Test
    public void putTest() {
        Map<String, Integer> map = new MyHashMap<>();

        map.put("Number 1", 1);

        assertEquals(1, map.get("Number 1"));
    }

    @Test
    public void getNull() {
        Map<String, Integer> map = new MyHashMap<>(2);

        map.put("Sun", 1);
        map.put("Moon", 2);

        assertNull(map.get("Mars"));
    }

    @Test
    public void getDifferentKeyObject() {
        Map<Integer, String> map = new MyHashMap<>();

        map.put(1, "Sun");
        map.put(1000, "Moon");

        assertEquals("Sun", map.get(1));
        assertEquals("Moon", map.get(1000));
    }

    @Test
    public void getDifferentKeyObjectV2() {
        Map<String, String> map = new MyHashMap<>();

        var keyBefore = getStr(1);
        var keyAfter = "Number 1";

        map.put(keyBefore, "Sun");

        assertEquals(keyBefore.hashCode(), keyAfter.hashCode());
        assertEquals("Sun", map.get(keyBefore));
        assertEquals("Sun", map.get(keyAfter));
    }

    private String getStr(Integer i) {
        return "Number " + i;
    }

    @Test
    public void test() {
        Map<String, Integer> map = new MyHashMap<>(2);

        map.put("Sun", 1);
        map.put("Moon", 2);
        map.put("Mars", 3);

        assertEquals(1, map.get("Sun"));
        assertEquals(2, map.get("Moon"));
        assertEquals(3, map.get("Mars"));

    }
}
