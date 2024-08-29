package com.doong.exp.program0828;

public class Program {

    public static void main(String[] args) {
        NumberThread numberThread = new NumberThread();
        AlphabetThread alphabetThread = new AlphabetThread();

        numberThread.start();
        alphabetThread.start();

        try {
            numberThread.join();
            alphabetThread.join();
        }catch (InterruptedException e) {
            System.err.println("메인 쓰레드 중단");
        }
    }

    static class NumberThread extends Thread{
        @Override
        public void run() {
            for(int i=1; i<=10; i++){
                System.out.println(i);
            }
        }
    }
    static class AlphabetThread extends Thread{
        @Override
        public void run() {
            for(int i=0;i<26;i++){
                System.out.println( (char)('A' + i));
            }
        }
    }

}
