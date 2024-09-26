package com.doong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication(scanBasePackages = "com.doong")
public class DoongApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoongApplication.class, args);
	}
}
