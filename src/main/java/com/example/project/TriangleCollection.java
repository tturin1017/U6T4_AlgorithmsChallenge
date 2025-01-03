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

    public static void main(String[] args) {

        Point p1 = new Point(5, 10);
        Point p2 = new Point(-6, 17);
        Point p3 = new Point(18, 4);
        System.out.println(p1.distanceTo(p2));
        System.out.println(p2.distanceTo(p3));
        System.out.println(p1.distanceTo(p3));
    
        Point p4 = new Point(-1, 4);
        Point p5 = new Point(4, 0);
        Point p6 = new Point(-1, 0);
System.out.println("Testing Triangle class");
        Triangle tri1 = new Triangle(p1, p2, p3);
        System.out.println(tri1.triangleInfo());
        System.out.println(tri1.perimeter());
    
        Triangle tri2 = new Triangle(p4, p5, p6);
        System.out.println(tri2.triangleInfo());
        System.out.println(tri2.perimeter());
    
        System.out.println("\n----- TESTING TriangleCollection class -----");
        // TEST TriangleCollection constructor and toString methods
        TriangleCollection collection1 = new TriangleCollection(6, 4, 7);
        System.out.println("collection 1's Triangles:");
        System.out.println(collection1.triangleCollectionInfo());
    
        TriangleCollection collection2 = new TriangleCollection(10, 7, 3);
        System.out.println("\ncollection 2's Triangles:");
        System.out.println(collection2.triangleCollectionInfo());
    
        // TEST TriangleCollection totalPerimeter method
        System.out.println("collection 1 total perim = " + collection1.totalPerimeter());
        System.out.println("collection 2 total perim = " + collection2.totalPerimeter());

            // TEST TriangleCollection shiftTriangles method
            collection1.shiftTriangles(5);
            System.out.println("\ncollection 1's Triangles after shift:");
            System.out.println(collection1.triangleCollectionInfo());
        
            collection2.shiftTriangles(10);
            System.out.println("collection 2's Triangles after shift:");
            System.out.println(collection2.triangleCollectionInfo());
    

    }
 }
 