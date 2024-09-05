package com.doong.exp.program0904.controller;

import com.doong.exp.program0904.model.prototype.Car;
import com.doong.exp.program0904.model.web_request.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RacingGameContrller {
    private final Car car;
    private final Logger logger;
    @Autowired
    public RacingGameContrller(Car car, Logger logger) {
        System.out.println("RacingGameContrller 생성자 생성");
        this.car = car;
        this.logger = logger;
    }
    @GetMapping("/race")
    public String raceCar(){
        car.race();
        System.out.println("[" + logger.getUuid() +"]");
        //Car findCar = car.getObject();
        //findCar.race();

        return "경주 끝";
    }
}
