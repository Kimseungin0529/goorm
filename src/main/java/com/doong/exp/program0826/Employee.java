package com.doong.exp.program0826;

public class Employee {
    protected String name;
    protected int  annualIncome;
    protected String rank;

    public Employee(String name, int annualIncome, String rank) {
        this.name = name;
        this.annualIncome = annualIncome;
        this.rank = rank;
    }

    public void informPayRise(){
        System.out.println(String.format("저의 직급은 직원인 %s입니다.", this.rank));
    }
}
