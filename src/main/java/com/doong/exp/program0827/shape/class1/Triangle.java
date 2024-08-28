package com.doong.exp.program0827.shape.class1;

public class Triangle extends Shape {

    private int transverse;
    private int length;

    public Triangle(int transverse, int length) {
        this.transverse = transverse;
        this.length = length;
    }

    @Override
    public double calculateArea() {
        return 0.5 * this.transverse * this.length;
    }
}
