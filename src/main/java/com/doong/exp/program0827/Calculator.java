package com.doong.exp.program0827;

public class Calculator {
    public double plus(double first, double second){
        return first + second;
    };

    public double minus(double first, double second){
        return first - second;
    };
    public double multiple(double first, double second){
        return first * second;
    };
    public double divide(double first, double second){
        if(second == 0){
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        return first / second;
    };

}
