package com.doong.exp.program0826;

public class Circle extends Shapes{

    final double PI = 3.14;
    int radius;

    public Circle(String name, int radius) {
        super(name);
        this.radius = radius;
    }

    public double calculateArea(){
        return Math.pow(radius, 2) * PI;
    }

    @Override
    public void showShapeInform() {
        System.out.println(String.format("%s 도형의 넓이는 %.2f 입니다.",getName(), calculateArea()));
    }
}
