package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    StringUtils su;
    @BeforeEach
    void setUp(){
        su = new StringUtils();
    }
    @Test
    void testisBalanced1(){
        String sTest = "{a}";
        boolean result = su.isBalanced(sTest);
        assertEquals(result,false);
    }
    @Test
    void testisBalanced2(){
        String sTest = "{()[]}";
        boolean result = su.isBalanced(sTest);
        assertEquals(result,true);
    }
    @Test
    void testisBalanced3(){
        String sTest = "(";
        boolean result = su.isBalanced(sTest);
        assertEquals(result,false);
    }
    @Test
    void testisBalanced4(){
        String sTest = "{)(}";
        boolean result = su.isBalanced(sTest);
        assertEquals(result,false);
    }
    @Test
    void testisBalanced5(){
        String sTest = "";
        boolean result = su.isBalanced(sTest);
        assertEquals(result,true);
    }
    @Test
    public void testisBalanced6(){
        assertThrows(IllegalArgumentException.class, () -> {
            su.isBalanced(null);
        });
    }
    @Test
    void testisBalanced7(){
        String sTest = "{(})";
        boolean result = su.isBalanced(sTest);
        assertEquals(result,false);
    }
}