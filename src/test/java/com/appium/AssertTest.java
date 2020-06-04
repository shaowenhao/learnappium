package com.appium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Description:
 * date: 2020 2020/6/3 19:29
 *
 * @author shaowenhao
 * @since JDK 1.8
 */
public class AssertTest {
    @Test
    public void assertTest() {
        Integer a = new Integer(1);
        Integer b = new Integer(2);
        assertEquals(a, b);
        assertNotNull(a);
        assertTrue(false);
        assertSame(a, b);
        assertArrayEquals(new int[]{7, 8, 9}, new int[]{2, 3, 4});
    }
}
