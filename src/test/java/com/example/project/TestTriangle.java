package com.example.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTriangle{
    @Test
    public void testConstructorAndGetVertices(){
        Point p1 = new Point(5, 10);
        Point p2 = new Point(-6, 17);
        Point p3 = new Point(18, 4);
        Triangle t = new Triangle(p1,p2,p3);
        Point[] expected = {p1,p2,p3};
        assertArrayEquals(expected, t.getVertices(), "getVertices() doesn't return the correct results for triangle with points (5,10),(-6,17),(18,4)");
    }

    @Test
    public void testPerimeter(){
        Point p1 = new Point(5, 10);
        Point p2 = new Point(-6, 17);
        Point p3 = new Point(18, 4);
        Point p4 = new Point(-1, 4);
        Point p5 = new Point(4, 0);
        Point p6 = new Point(-1, 0);

        Triangle tri1 = new Triangle(p1,p2,p3);
        Triangle tri2 = new Triangle(p4,p5,p6);
        assertEquals(54.65091400159402, tri1.perimeter(), "Expected perimeter -> 54.65091400159402");
        assertEquals(15.403124237432849,tri2.perimeter(),"Expected perimeter ->15.403124237432849");
    }

    @Test
    public void testTriangleInfo(){
        Point p1 = new Point(5, 10);
        Point p2 = new Point(-6, 17);
        Point p3 = new Point(18, 4);
        Point p4 = new Point(-1, 4);
        Point p5 = new Point(4, 0);
        Point p6 = new Point(-1, 0);

        Triangle tri1 = new Triangle(p1,p2,p3);
        Triangle tri2 = new Triangle(p4,p5,p6);
        assertEquals("[(5, 10), (-6, 17), (18, 4)]", tri1.triangleInfo(), "expected [(5, 10), (-6, 17), (18, 4)]");
        assertEquals("[(-1, 4), (4, 0), (-1, 0)]", tri2.triangleInfo(), "expected [(-1, 4), (4, 0), (-1, 0)]");
    }
    

}