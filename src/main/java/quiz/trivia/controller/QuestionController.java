package quiz.trivia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import quiz.trivia.entity.Question;
import quiz.trivia.entity.Score;
import quiz.trivia.service.QuestionService;
import quiz.trivia.service.ScoreService;
import quiz.trivia.utils.Res;
import quiz.trivia.utils.dto.response.AnswerResponse;
import quiz.trivia.utils.dto.response.QuestionResponse;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    
    @Autowired
    QuestionService questionService;

    @Autowired
    ScoreService scoreService;

    @GetMapping("/start")
    public ResponseEntity<?> getQuestion() {
        Question question = questionService.getRandomQuestion();
        QuestionResponse response = QuestionResponse.response(question);
        return Res.renderJson(response, "Enjoy the game!", HttpStatus.OK);
    }

    @GetMapping("/submit-answer")
    public ResponseEntity<?> submitAnswer(@RequestParam String questionId, @RequestParam Integer userId, @RequestParam String answer) {
        Question question = questionService.findById(questionId);
        boolean correctAnswer = question.getCorrectAnswer().equalsIgnoreCase(answer);
        Score score = scoreService.addScore(userId, correctAnswer);

        String message = correctAnswer ? "correct" : "incorrect";

        if (scoreService.AnsweredQuestion(score)) {
            message = "Congratulations! You answered 10 questions. Your total score is " + score.getScored();
        }

        AnswerResponse response = AnswerResponse.response(score, message);

        return Res.renderJson(response, "success update score", HttpStatus.OK);
    }
}
