package com.example.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTriangleCollection{
    @Test
    public void testTriangleCollection(){
        TriangleCollection collection1 = new TriangleCollection(6,4,7);
        String expected = 
        "[(-4, 0), (0, 7), (4, 0)]\n"+
        "[(-4, 0), (0, 7), (3, 0)]\n"+
        "[(-4, 0), (0, 7), (2, 0)]\n"+
        "[(-4, 0), (0, 7), (1, 0)]\n"+
        "[(-4, 0), (0, 7), (0, 0)]\n"+
        "[(-4, 0), (0, 7), (-1, 0)]\n";
        assertEquals(expected,collection1.triangleCollectionInfo());

        TriangleCollection collection2 = new TriangleCollection(10,7,3);
        expected = 
        "[(-7, 0), (0, 3), (7, 0)]\n"+
        "[(-7, 0), (0, 3), (6, 0)]\n"+
        "[(-7, 0), (0, 3), (5, 0)]\n"+
        "[(-7, 0), (0, 3), (4, 0)]\n"+
        "[(-7, 0), (0, 3), (3, 0)]\n"+
        "[(-7, 0), (0, 3), (2, 0)]\n"+
        "[(-7, 0), (0, 3), (1, 0)]\n"+
        "[(-7, 0), (0, 3), (0, 0)]\n"+
        "[(-7, 0), (0, 3), (-1, 0)]\n"+
        "[(-7, 0), (0, 3), (-2, 0)]\n";

        assertEquals(expected,collection2.triangleCollectionInfo());
    }

    @Test 
    public void testTotalPerimeter(){
        TriangleCollection collection1 = new TriangleCollection(6,4,7);
        TriangleCollection collection2 = new TriangleCollection(10,7,3);

        assertEquals(125.47382285696523,collection1.totalPerimeter());
        assertEquals(217.09095855023168,collection2.totalPerimeter());
    }

    @Test
    public void testShiftTriangles(){
        TriangleCollection collection1 = new TriangleCollection(6,4,7);
        String expected = 
        "[(1, 5), (5, 12), (9, 5)]\n"+
        "[(1, 5), (5, 12), (8, 5)]\n"+
        "[(1, 5), (5, 12), (7, 5)]\n"+
        "[(1, 5), (5, 12), (6, 5)]\n"+
        "[(1, 5), (5, 12), (5, 5)]\n"+
        "[(1, 5), (5, 12), (4, 5)]\n";
        collection1.shiftTriangles(5);
        assertEquals(expected,collection1.triangleCollectionInfo());

        TriangleCollection collection2 = new TriangleCollection(10,7,3);
        expected = 
        "[(3, 10), (10, 13), (17, 10)]\n"+
        "[(3, 10), (10, 13), (16, 10)]\n"+
        "[(3, 10), (10, 13), (15, 10)]\n"+
        "[(3, 10), (10, 13), (14, 10)]\n"+
        "[(3, 10), (10, 13), (13, 10)]\n"+
        "[(3, 10), (10, 13), (12, 10)]\n"+
        "[(3, 10), (10, 13), (11, 10)]\n"+
        "[(3, 10), (10, 13), (10, 10)]\n"+
        "[(3, 10), (10, 13), (9, 10)]\n"+
        "[(3, 10), (10, 13), (8, 10)]\n";

        collection2.shiftTriangles(10);

        assertEquals(expected,collection2.triangleCollectionInfo());
    }

}