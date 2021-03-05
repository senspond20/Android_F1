package com.example.blank;

import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    private final String TAG = "ExampleUnitTest";

    @Test
    public void logTest(){
        System.out.println("안녕하세요");


        Log.v(TAG,"안녕하세요");
    }
}