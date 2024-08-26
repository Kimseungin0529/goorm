package com.doong.exp.program0826;

public class Mannager extends Employee{
    public Mannager(String name, int annualIncome, String rank) {
        super(name, annualIncome, rank);
    }

    @Override
    public void informPayRise() {
        System.out.println(String.format("저의 직급은 관리자인 %s입니다.", this.rank));
    }
}
