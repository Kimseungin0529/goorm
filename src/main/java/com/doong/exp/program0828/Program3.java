package com.doong.exp.program0828;

import java.util.Scanner;
import java.util.function.BiFunction;

public class Program3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double number1 = sc.nextInt();
        double number2 = sc.nextInt();
        String operator = sc.next();
        // 연산자에 따른 람다식 선택
        BiFunction<Double, Double, Double> operation = null;
        switch (operator) {
            case "+":
                operation = (a, b) -> a + b;
                break;
            case "-":
                operation = (a, b) -> a - b;
                break;
            case "*":
                operation = (a, b) -> a * b;
                break;
            case "/":
                operation = (a, b) -> {
                    if (b == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        return null;
                    }
                    return a / b;
                };
                break;
        }
        if(operation != null){
            Double result = operation.apply(number1, number2);
            System.out.println(String.format("계산 결과는 %f 입니다", result));
        }

    }
}
