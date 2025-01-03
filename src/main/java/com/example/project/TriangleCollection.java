package com.example.project;


public class TriangleCollection {
    private Triangle[] collection;
 
 
    public TriangleCollection(int numTriangles, int startX, int startY) {
        collection = new Triangle[numTriangles];
 
 
        for (int i = 0; i < collection.length; i++) {
            Point p1 = new Point(-startX, 0);
            Point p2 = new Point(0, startY);
            Point p3 = new Point(startX - i, 0);
            Triangle triangle = new Triangle(p1, p2, p3);
            collection[i] = triangle;
        }
    }
 
 
    public double totalPerimeter() {
        double totalPerim = 0.0;
        for (Triangle triangle : collection) {
            totalPerim += triangle.perimeter();
        }
        return totalPerim;
    }
 
 
    public void shiftTriangles(int increment) {
        for (Triangle triangle : collection) {
            Point[] vertices = triangle.getVertices();
 
 
            for (Point vertex : vertices) {
                int currentX = vertex.getX();
                int currentY = vertex.getY();
                vertex.setX(currentX + increment);
                vertex.setY(currentY + increment);
            }
        }
    }
 
 
    public String triangleCollectionInfo() {
        String triangleString = "";
        for (Triangle triangle : collection) {
            triangleString += triangle.triangleInfo();
            triangleString += "\n";
        }
        return triangleString;
    }
 }
 