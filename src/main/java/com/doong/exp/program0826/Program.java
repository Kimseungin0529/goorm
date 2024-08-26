package com.doong.exp.program0826;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Program {
    private Rectangle rectangle;
    private Employee employee;

    public Program(Rectangle rectangle, Employee employee) {
        this.rectangle = rectangle;
        this.employee = employee;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //showRectangle(sc);
        //showRelatedCompanyInform();
        showShapesArea();
    }

    private static void showShapesArea() {
        Triangle triangle = new Triangle("삼각형", 3, 5);
        Circle circle = new Circle("원", 4);

        List<Shapes> arrayList = new ArrayList<>();
        arrayList.add(triangle);
        arrayList.add(circle);

        for(Shapes shape : arrayList){
            shape.showShapeInform();
        }
    }

    private static void showRelatedCompanyInform() {
        Employee createdEmployee = new Employee("김승진", 10000000, "과장");
        Mannager createMannager = new Mannager("홍길동", 20000000, "사장이요~");

        createMannager.informPayRise();
        createdEmployee.informPayRise();
    }

    private static void showRectangle(Scanner sc) {
        Rectangle rectangle = new Rectangle();
        int transverse = sc.nextInt();
        int length = sc.nextInt();
        int calculatedArea = rectangle.calculateArea(transverse, length);
        int calculatedCircumference = rectangle.calculateCircumference(transverse, length);

        System.out.println("직사각형의 넓이는  " + calculatedArea + "이고, 둘레는 " + calculatedCircumference + "입니다.");
    }
}
