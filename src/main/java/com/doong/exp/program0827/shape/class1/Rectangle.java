package com.doong.exp.program0827.shape.class1;

public class Rectangle extends Shape {

    private int transverse;
    private int length;


    public Rectangle(int transverse, int length) {
        this.transverse = transverse;
        this.length = length;
    }

    @Override
    public double calculateArea() {
        return this.transverse * this.length;
    }
}
