package com.doong.exp.program0905.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter @Setter
public class QuizQuestion {

    private String content;
    private String answer;
    private String correctAnswer;
    private boolean isCorrected;
    private int score;

    public QuizQuestion(String content,String correctAnswer, int score) {
        checkScoreRange(score);
        this.content = content;
        this.answer = null;
        this.correctAnswer = correctAnswer;
        this.isCorrected = false;
        this.score = score;
    }

    private static void checkScoreRange(int score) {
        if(0 > score || score > 100){
            throw new IllegalArgumentException("점수는 0 ~ 100 까지 표현 가능합니다.");
        }
    }

    public void subjectAnswer(String answer){
        this.answer = answer;
    }

    public boolean checkCorrectedAnswer(){
        return this.correctAnswer.equals(this.answer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizQuestion that = (QuizQuestion) o;
        return isCorrected == that.isCorrected && score == that.score && Objects.equals(content, that.content) && Objects.equals(answer, that.answer) && Objects.equals(correctAnswer, that.correctAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, answer, correctAnswer, isCorrected, score);
    }
}
