package com.example.project;

public class Fibonacci {
    // instance variable
    private int[] sequence;
    
    /** Constructor: sets sequence instance variable to an array containing the
        first seqLen numbers in a Fibonacci sequence.
        A Fibonacci sequence is formed by summing the
        previous two numbers to generate the next number,
        e.g. 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...
    
        All Fibonacci sequences start out with 0 and 1 as the first two numbers.
    
        PRECONDITION: seqLen >= 2
      */
    public Fibonacci(int seqLen) {
      sequence = new int[seqLen];
     
      // precondition states that sequenceLen will be at least 2
      sequence[0] = 0;
      sequence[1] = 1;
     
      for (int i = 2; i < sequence.length; i++) {
        sequence[i] = sequence[i - 1] + sequence[i - 2];
      }
    }
    
    /** Getter method: returns a reference to the sequence array*/
    public int[] getSequence() {
      return sequence;
    }
    
    /** Returns the index in the array where a particular value, searchVal, is
        located in sequence; if not found, returns -1.  If searchVal == 1, return
        first index where 1 is found (since this value appears twice in Fibonacci
        sequences longer than 2 numbers)
     */
    public int getIndexOf(int searchVal) {
      for (int i = 0; i < sequence.length; i++) {
        if (sequence[i] == searchVal) {
          return i;
        }
      }
      return -1;
    }
     /** Creates a temp array that contains the original sequence array with
        howManyMore numbers Fibonacci values added on to the end,
        then assigns sequence to that new array.
    
        For example, if sequence == {0, 1, 1, 2, 3, 5} and this method is called
        with howManyMore == 3, sequence would be assigned to a new array with
        the next 2 Fibonacci numbers: {0, 1, 1, 2, 3, 5, 8, 13, 21}
     */
    public void extendBy(int howManyMore) {
      int[] extendedSeq = new int[sequence.length + howManyMore];
     
      // fill up extendedSeq
      for (int i = 0; i < extendedSeq.length; i++) {
        // copy over values from sequence array to extendedSeq array
        if (i < sequence.length) {
          extendedSeq[i] = sequence[i];
        } else {
          // fill out the extra spaces with new Fibonacci values
          extendedSeq[i] = extendedSeq[i - 1] + extendedSeq[i - 2];
        }
      }
     
      // assign sequence to the new array
      sequence = extendedSeq;
    }
    
    /** Returns a string that represents the sequence array nicely formatted,
     *  for example, if sequence == [2, 3, 7], this method should return the String
     *  "[2, 3, 7]"
     *  ** USE THE printableString UTILITY METHOD IN YOUR ARRAYALGORITHMS CLASS! **
     */
    public String fibonacciString() {
      return ArrayPrinter.printableString(sequence);
    }
   }
    // public void extendBy(int howManyMore)
    // {
    //   sequence = new int[sequence.length + howManyMore];
    
    //   // same approach as used in the constructor
    //   sequence[0] = 0;
    //   sequence[1] = 1;
    
    //   for(int i = 2; i < sequence.length; i++)
    //   {
    //     sequence[i] = sequence[i - 1] + sequence[i-2];
    //   }
    // }
   