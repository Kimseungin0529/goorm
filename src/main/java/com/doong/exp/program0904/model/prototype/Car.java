package com.doong.exp.program0904.model.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Car {
    private final Engine engine;
    @Autowired
    public Car(@Qualifier("electricEngine") Engine engine) {
        this.engine = engine;
        System.out.println("Car 생성자 생성 완료" + this.toString());
    }
    public void race() {
        this.engine.start();
    }
}
