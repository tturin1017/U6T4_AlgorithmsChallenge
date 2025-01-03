package com.example.project;

public class Point {
    private int x;
    private int y;
 
 
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
 
    public int getX() {return x;}
    public void setX(int newX) {x = newX;}
    public int getY() {return y;}
    public void setY(int newY) {y = newY;}

    public double distanceTo(Point other) {
        int diffx = x - other.x;
        int diffy = y - other.y;
        return Math.sqrt(diffx * diffx + diffy * diffy);
    }
 
 
    public String pointInfo() {return "(" + x + ", " + y + ")";}
 }
 