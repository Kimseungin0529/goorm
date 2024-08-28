package com.doong.exp.program0827.shape.class1;

public class Circle extends Shape {

    private static final double PI = 3.14;
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.pow(this.radius,2) * PI;
    }
}
