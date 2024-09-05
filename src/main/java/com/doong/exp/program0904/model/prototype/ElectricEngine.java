package com.doong.exp.program0904.model.prototype;

import org.springframework.stereotype.Component;

@Component
public class ElectricEngine implements Engine{
    public ElectricEngine() {
        System.out.println("ElectricEngine 생성자 생성 - 싱글톤");
    }

    @Override
    public void start() {
        System.out.println("Electric Engine is starting…");
    }
}
