package com.doong.exp.program0826;

public abstract class Shapes {

    private String name;

    public abstract double calculateArea();

    public abstract void showShapeInform();

    public Shapes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
