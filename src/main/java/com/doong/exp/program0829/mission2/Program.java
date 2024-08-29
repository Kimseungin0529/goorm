package com.doong.exp.program0829.mission2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 1. HashMap을 사용하여 여러 학생의 이름과 점수를 저장하는 프로그램을 구현합니다.
 * 2. 사용자는 HashMap에 데이터를 추가, 조회, 삭제할 수 있어야 합니다.
 * 3. HashMap에 저장된 데이터의 모든 키와 값을 반복문을 통해 출력합니다.
 * 4. HashMap에서 특정 키를 검색하여 해당 값을 출력하는 기능을 구현합니다
 */
public class Program {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ScoreManageMent scoreManageMent = new ScoreManageMent();
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            scoreManageMent.addData(name, score);
        }
        scoreManageMent.findAllData(); // 저장된 모든 키와 값을 출력
        for(int i=0; i<3; i++){
            String st = br.readLine();
            if(st.equals("add")){
                String[] str = br.readLine().split(" ");
                scoreManageMent.addData(str[0], Integer.parseInt(str[1]));
                System.out.println("정보를 추가했습니다.");
            } else if (st.equals("get")){
                String str = br.readLine();
                scoreManageMent.findData(str);
                System.out.println(String.format("조회한 정보 : 이름은 %s이고 점수는 %d 입니다.", str, scoreManageMent.findData(str)));
            } else if(st.equals("remove")){
                String str = br.readLine();
                scoreManageMent.removeDate(str);
                System.out.println("해당 정보를 삭제했습니다.");
            }

        }



    }
}
