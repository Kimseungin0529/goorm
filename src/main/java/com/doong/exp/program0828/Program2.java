package com.doong.exp.program0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb1 = new StringBuilder(br1.readLine());
        System.out.println(String.format("뒤집힌 문자열은 [ %s ] 입니다.", sb1.reverse()));


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<inputString.length(); i++){
            char now = inputString.charAt(i);
            if(Character.isUpperCase(now)){
                sb.append(Character.toLowerCase(now));
            }else if (Character.isLowerCase(now)) {
                sb.append(Character.toUpperCase(now));
            } else {
                sb.append(now);
            }
        }
        System.out.println(sb);

    }

}
