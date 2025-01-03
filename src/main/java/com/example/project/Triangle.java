package com.example.project;


public class Triangle {
    private Point[] vertices;

    public Triangle(Point p1, Point p2, Point p3) {
        vertices = new Point[] {p1, p2, p3};
    }
 
 
    public Point[] getVertices() {
        return vertices;
    }
 
 
    public double perimeter() {
        double side1 = vertices[0].distanceTo(vertices[1]);
        double side2 = vertices[1].distanceTo(vertices[2]);
        double side3 = vertices[2].distanceTo(vertices[0]);
        return side1 + side2 + side3;
    }
 
 
    public String triangleInfo() {
        String str = "[" + vertices[0].pointInfo() + ", "
                + vertices[1].pointInfo()  + ", "
                + vertices[2].pointInfo() + "]";
        return str;
    }
   
 }
 