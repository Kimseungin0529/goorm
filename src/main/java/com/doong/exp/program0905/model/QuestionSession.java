package com.doong.exp.program0905.model;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component @Slf4j
@SessionScope @Getter
public class QuestionSession {

    private static final int QUIZ_LIST_SIZE = 3;

    private int currentQuestionIndex = 0;
    private List<QuizQuestion> quizQuestionList = new ArrayList<>();

    public QuestionSession() {
        QuizQuestion quiz1 = new QuizQuestion("퀴즈1의 답안은 '퀴즈1' 입니다.", "퀴즈1", 100);
        QuizQuestion quiz2 = new QuizQuestion("퀴즈2의 답안은 '퀴즈2' 입니다.", "퀴즈2", 100);
        QuizQuestion quiz3 = new QuizQuestion("퀴즈3의 답안은 '퀴즈3' 입니다.", "퀴즈3", 100);
        List<QuizQuestion> quizes = List.of(quiz1, quiz2, quiz3);

        quizes.stream()
                .forEach(quizQuestion -> quizQuestionList.add(quizQuestion));
        checkQuizSize(quizQuestionList.size());
        log.info("QuestionSession 생성");
    }

    // 현재 문제 반환
    public QuizQuestion getCurrentQuestion() {
        if (currentQuestionIndex < quizQuestionList.size()) {
            return quizQuestionList.get(currentQuestionIndex);
        }
        return null;  // 퀴즈가 끝난 경우 null 반환
    }

    // 다음 문제로 이동
    public void moveToNextQuestion() {
        if (currentQuestionIndex < quizQuestionList.size() - 1) {
            currentQuestionIndex++;
        }
    }

    // 세션을 리셋 (퀴즈 재시작)
    public void resetSession() {
        currentQuestionIndex = 0;
        quizQuestionList.forEach(quiz -> quiz.setCorrected(false));  // 상태 초기화
        log.info("퀴즈 세션 초기화");
    }

    private static void checkQuizSize(int size) {
        if(size!= QUIZ_LIST_SIZE){
            throw new IllegalStateException("정해진 퀴즈 개수는 총 3개 입니다.");
        }
    }

    public int getNumberOfQuestionSubmission(){
        return (int)this.quizQuestionList.stream()
                .filter(quizQuestion -> Optional.of(quizQuestion.getAnswer()).isPresent())
                .count();
    }

    public void addQuiz(QuizQuestion quizQuestion){
        quizQuestionList.add(quizQuestion);
    }

    public int calculateTotalScore(){
        return this.quizQuestionList.stream()
                .filter(quizQuestion -> quizQuestion.isCorrected())
                .mapToInt( quiz -> quiz.getScore())
                .sum();
    }
}
