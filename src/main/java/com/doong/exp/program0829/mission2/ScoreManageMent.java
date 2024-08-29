package com.doong.exp.program0829.mission2;

import java.util.HashMap;
import java.util.Map;

public class ScoreManageMent {
    private Map<String, Integer> map = new HashMap<>();


    public void addData(String name, Integer score){
        this.map.put(name, score);
    }

    public Integer findData(String name){
        return this.map.get(name);
    }

    public void removeDate(String name){
        this.map.remove(name);
    }

    public void findAllData(){
        StringBuilder sb = new StringBuilder();
        this.map.entrySet().stream()
                .forEach(entry ->
                        sb.append(String.format("이름 : %s, 점수 : %d\n", entry.getKey(), entry.getValue())));
        System.out.println(sb);
    }

}
