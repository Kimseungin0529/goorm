package com.doong.exp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Program {

    static class OddEvenDiscriminator{
        private final static String EVEN_STRING = "는 짝수입니다.";
        private final static String ODD_STRING = "는 홀수입니다.";
        public void distinguish(int number){
            if(isEven(number)){
                System.out.println(number + EVEN_STRING);
                return;
            }
            System.out.println(number + ODD_STRING);
        }
        private static boolean isEven(int number) {
            return number % 2 == 0;
        }
    }

    static class NumberStore{
        private final List numberList = new ArrayList();

        public void saveNumbers(int[] numbers){
            for(int index = 0; index < numbers.length; index++){
                numberList.add(numbers[index]);
            }
        }
        public void showSavedNumbers(){
            StringBuilder stringBuilder = new StringBuilder();
            numberList.stream()
                    .forEach( number -> stringBuilder.append(number + " "));
            System.out.println(stringBuilder);
        }
    }
    static class Sort{
        private int[] values = new int[5];


        public void saveValues(List<Integer> list){
            for(int i=0; i<values.length; i++){
                values[i] = list.get(i);
            }
        }
        public void sort(){
            for(int i=0;i<5;i++){
                for(int j=i+1;j<5;j++){
                    if(values[i] > values[j]){
                        int tmp = values[i];
                        values[i] = values[j];
                        values[j] = tmp;
                    }
                }
            }
        }

        public void showValues(){
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0; i<values.length; i++){
                stringBuilder.append(values[i] + " ");
            }
            System.out.println(stringBuilder);

        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        List<Integer> list = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()){
            int value = Integer.parseInt(stringTokenizer.nextToken());
            list.add(value);
        }

        Sort sort = new Sort();
        sort.saveValues(list);
        sort.sort();
        sort.showValues();

    }



}
