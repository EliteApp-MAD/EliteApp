package com.example.elitepage1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    //private newReg newReg;
   // public  void setUp(){
       // newReg = newReg();
    //}
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void multipication_isCorrect() {
        newReg newreg = new newReg();
        float result = newreg.calculateProfite(100,10);
        assertEquals(1000,result,0.0001);
    }
}