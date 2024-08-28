package com.doong.exp.program0827;

import com.doong.exp.program0827.shape.intreface.Circle;
import com.doong.exp.program0827.shape.intreface.Rectangle;
import com.doong.exp.program0827.shape.intreface.Shape;
import com.doong.exp.program0827.shape.intreface.Triangle;

import java.util.List;

public class Program {
    // TODO: 2024-08-27
    //  1. 도형 인터페이스를 작성합니다. 이 인터페이스에는 도형의 면적을 계산하는 메서드가 정의되어 있어야 합니다.
    //  2. 도형 인터페이스를 구현하는 구체적인 도형 클래스(예: 원, 사각형, 삼각형 등)를 작성합니다.
    //  3. 도형 인터페이스를 구현한 도형 클래스의 객체를 생성하고, 면적 계산 메서드를 호출하여 그 결과를 출력합니다.

    // TODO: 2024-08-27
    //  1. 사칙연산(덧셈, 뺄셈, 곱셈, 나눗셈)을 수행하는 계산기 프로그램을 작성합니다.
    //  2. 사용자가 잘못된 입력(예: 0으로 나누기)을 할 경우 적절한 예외를 처리하고 오류 메시지를 출력합니다.

    // TODO: 2024-08-27
    //  1. 도형 추상 클래스를 작성하고, 이를 상속받는 구체적인 도형 클래스(원, 사각형, 삼각형 등)를 작성합니다.
    //  2. 도형 인터페이스를 정의하고, 도형 추상 클래스와 구체적인 도형 클래스에서 이를 구현합니다.
    //  3. 다양한 도형 객체를 생성하고 배열에 저장한 뒤, 각 도형의 면적을 계산하여 출력합니다.

    public static void main(String[] args) {
        // showShapesInform();

        // showCalculation();

        Circle circle = new Circle(4);
        Rectangle rectangle = new Rectangle(4, 5);
        Triangle triangle = new Triangle(4, 5);

        Shape[] shapes = List.of(circle, rectangle, triangle).toArray(value -> new Shape[value]);
        for(Shape shape :shapes){
            System.out.println("이 도형의 넗이는 " + shape.calculateArea()+ "입니다.");
        }
    }

    private static void showCalculation() {
        try {
            Calculator calculator = new Calculator();
            calculator.plus(1 , 4);
            calculator.minus(2, 1);
            calculator.multiple(12, 3);
            calculator.divide(20, 0);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    private static void showShapesInform1() {
        Circle circle = new Circle(4);
        Rectangle rectangle = new Rectangle(4, 5);
        Triangle triangle = new Triangle(4, 5);

        List<Shape> shapes = List.of(circle, rectangle, triangle);

        shapes.stream().forEach(shape -> System.out.println("이 도형의 넗이는 " + shape.calculateArea()+ "입니다."));
    }
}
