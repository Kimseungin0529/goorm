package com.doong.exp.program0827.shape.intreface;

public class Triangle implements Shape {

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
