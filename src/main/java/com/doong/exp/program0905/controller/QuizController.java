package com.doong.exp.program0905.controller;

import com.doong.exp.program0905.model.QuestionSession;
import com.doong.exp.program0905.model.QuizQuestion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class QuizController {
    private final QuestionSession questionSession;
    // 서비스 로직은 생성 X

    public QuizController(QuestionSession questionSession) {
        this.questionSession = questionSession;
        log.info("QuizController 생성");
    }

    // 퀴즈 시작 화면: 첫 번째 문제 반환
    @GetMapping("/quiz")
    public String startQuiz(Model model) {
        log.info("퀴즈 시작");
        QuizQuestion currentQuestion = questionSession.getCurrentQuestion();
        model.addAttribute("quizQuestion", currentQuestion);
        return "quiz";  // "quiz.html" 템플릿 반환
    }

    // 퀴즈 제출: 사용자의 답안을 제출
    @PostMapping("/quiz")
    public String submitQuiz(@RequestParam String answer, Model model) {
        QuizQuestion currentQuestion = questionSession.getCurrentQuestion();
        currentQuestion.subjectAnswer(answer);

        if (currentQuestion.checkCorrectedAnswer()) {
            currentQuestion.setCorrected(true);
            log.info("정답입니다.");
        } else {
            log.info("오답입니다.");
        }

        // 다음 문제로 진행
        if(questionSession.getCurrentQuestionIndex() == 2){
            return "redirect:/quiz-result";
        }

        questionSession.moveToNextQuestion();
        model.addAttribute("quizQuestion", questionSession.getCurrentQuestion());

        return "quiz";  // 계속해서 다음 문제 표시
    }

    // 퀴즈 결과 화면: 점수와 완료 메시지 반환
    @GetMapping("/quiz-result")
    public String showQuizResult(Model model) {
        int totalScore = questionSession.calculateTotalScore();
        log.info("퀴즈 종료. 총 점수: {}", totalScore);
        model.addAttribute("totalScore", totalScore);
        return "quiz-result";  // "quiz-result.html" 템플릿 반환
    }

    // 퀴즈 재시작: 세션 초기화
    @PostMapping("/restart")
    public String restartQuiz() {
        questionSession.resetSession();
        log.info("퀴즈 재시작");
        return "redirect:/quiz";  // 퀴즈 다시 시작
    }

}
