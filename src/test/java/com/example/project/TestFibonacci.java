package com.example.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestFibonacci{
    @Test
    public void testConstructor(){
        Fibonacci fib = new Fibonacci(10);
        int[] expectedSequence = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        assertArrayEquals(expectedSequence,fib.getSequence(),"Constructor doesn't create the correct Fib Sequence");
    }

    @Test
    public void testGetSequence(){
        Fibonacci fib = new Fibonacci(5);
        int[] expected = {0,1,1,2,3};
        assertArrayEquals(expected,fib.getSequence(),"Incorrect return value of getSequence()");
    }

    @Test
    public void testGetIndexOf(){
        Fibonacci fib = new Fibonacci(10);
        assertEquals(1, fib.getIndexOf(1), "getIndexOf(1) should return the first index of 1.");
        assertEquals(7, fib.getIndexOf(13), "getIndexOf(13) should return the correct index.");
        assertEquals(-1, fib.getIndexOf(100), "getIndexOf(100) should return -1 when the value is not found.");
    }

    @Test
    public void testExtendBy(){
        Fibonacci fib = new Fibonacci(5);
        fib.extendBy(4);
        int[] expected = {0,1,1,2,3,5,8,13,21};
        assertArrayEquals(expected,fib.getSequence(),"extendBy() doesn't return the correct value");
    }

    @Test
    public void testFibonacciString(){
        Fibonacci fib = new Fibonacci(5);
        String expectedString = "[0, 1, 1, 2, 3]";
        assertEquals(expectedString, fib.fibonacciString(), "fibonacciString() did not return the correctly formatted string.");
    }

}