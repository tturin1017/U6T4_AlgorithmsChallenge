package com.example.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPoint{
    @Test
    public void testConstructor(){
        Point p = new Point(5,10);
        assertEquals(p.getX(),5, "getX() doesn't work");
        assertEquals(p.getY(), 10, "getY() doesn't work");
    }

    @Test
    public void testDistanceTo(){
        Point p1 = new Point(5, 10);
        Point p2 = new Point(-6, 17);
        Point p3 = new Point(18, 4);
        assertEquals(p1.distanceTo(p2),13.038404810405298, "p1 to p2 distance is wrong.");
        assertEquals(p2.distanceTo(p3),27.294688127912362, "p2 to p3 distance is wrong.");
        assertEquals(p1.distanceTo(p3),14.317821063276353, "p1 to p3 distance is wrong.");
    }

    @Test
    public void testPointInfo(){
        Point p = new Point(10,5);
        assertEquals("(10, 5)",p.pointInfo(),"pointInfo() doesn't return (x, y) format");
    }

}