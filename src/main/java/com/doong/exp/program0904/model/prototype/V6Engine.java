package com.doong.exp.program0904.model.prototype;

import org.springframework.stereotype.Component;

@Component
public class V6Engine implements Engine {
    public V6Engine() {
        System.out.println("V6Engine 생성자 생성 - 싱글톤");
    }

    @Override
    public void start() {
        System.out.println("V6 Engine is starting…");
    }
}
