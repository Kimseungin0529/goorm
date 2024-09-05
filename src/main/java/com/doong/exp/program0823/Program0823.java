package com.doong.exp.program0823;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Program0823 {
    static class Calculator{

        public int plusWith(int firstNumber, int secondNumber){
            return firstNumber + secondNumber;
        }
        public int minusWith(int firstNumber, int secondNumber){
            return firstNumber - secondNumber;
        }
    }

    @Getter
    static class PersonProfile{
        private String name;
        private int age;

        public PersonProfile(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void introduceYourSelf(){
            System.out.println("이름은 " + this.name + "이고 나이는 " +this.age + "입니다.");
        }
    }

    static class ArrayHandler{
        private List<Integer> array = new ArrayList<>();


        public void addValue(int value){
            this.array.add(value);
        }

        public void changeValueByIndex(int seletedIndex, int value){
            array.set(seletedIndex, value);
        }

        public Double calculateAverage(){
            return array.stream()
                    .mapToLong(value -> value.longValue())
                    .average()
                    .orElseThrow(() -> new IllegalStateException());
        }

        public void showArray(){
            String str = "";

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<array.size(); i++){
                sb.append(array.get(i) + " ");
            }
            System.out.println(sb);
        }
    }
    public static void main(String[] args) throws IOException {
        /*//1
        Scanner sc = new Scanner(System.in);
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();

        Calculator calculator = new Calculator();
        System.out.println(calculator.plusWith(firstNumber, secondNumber) + ", " + calculator.minusWith(firstNumber, secondNumber));*/

        //2
       /* Scanner sc = new Scanner(System.in);
        String inputName = sc.next();
        int inputAge = sc.nextInt();

        PersonProfile personProfile = new PersonProfile(inputName, inputAge);
        personProfile.introduceYourSelf();*/

        //3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayHandler arrayHandler = new ArrayHandler();
        while(st.hasMoreTokens()){
            int inputValue = Integer.parseInt(st.nextToken());
            arrayHandler.addValue(inputValue);
        }
        System.out.println(arrayHandler.calculateAverage());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int changeInputIndex = Integer.parseInt(st1.nextToken());
        int changeInputValue = Integer.parseInt(st1.nextToken());
        arrayHandler.changeValueByIndex(changeInputIndex, changeInputValue);

        arrayHandler.showArray();

    }
}
