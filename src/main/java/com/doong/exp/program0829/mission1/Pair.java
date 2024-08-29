package com.doong.exp.program0829.mission1;

import lombok.Getter;

/**
 * 1. 두 개의 타입 파라미터를 사용하는 제너릭 클래스(클래스명 ‘Pair’)를 구현합니다.
 * 2. 이 클래스는 두 개의 다른 타입의 데이터를 관리할 수 있어야 합니다.
 * 3. ‘PairMain ‘클래스의 메인 메서드에서 이 제너릭 클래스를 사용하여, String과 Integer 타입의 데이터를 각각 저장하고 출력합니다.
 * 4. 컴파일 시 타입 안전성을 확인하고, 강제 타입 변환이 불필요함을 실습합니다.
 */
@Getter
public class Pair<T, V> {
    private T value1;
    private V value2;

    public Pair(T value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public void showValues(){
        System.out.println(String.format
                ("value1은 %s이고 value2는 %d " +
                        "입니다.", this.value1, this.value2));
    }

}
