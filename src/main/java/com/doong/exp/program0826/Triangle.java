package com.doong.exp.program0826;

public class Triangle extends Shapes{

    int length;
    int transverse;

    public Triangle(String name, int length, int transverse) {
        super(name);
        this.length = length;
        this.transverse = transverse;
    }

    @Override
    public double calculateArea(){
        return 0.5 * this.length * this.transverse;
    }
    @Override
    public void showShapeInform() {
        System.out.println(String.format("%s 도형의 넓이는 %.2f 입니다.",getName(), this.calculateArea()));
    }
}
