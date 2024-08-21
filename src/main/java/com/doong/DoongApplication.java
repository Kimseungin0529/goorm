package com.doong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DoongApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age = 25;
		String name = "김승진";
		introduceSelf(age, name);

		//SpringApplication.run(DoongApplication.class, args);
	}
	public static void introduceSelf(int myAge, String myName){
		System.out.println("저의 나이는 " + myAge + "이고 이름은 " + myName + "입니다.");
	}

}
