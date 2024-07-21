package quiz.trivia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import quiz.trivia.entity.Question;
import quiz.trivia.service.TriviaService;
import quiz.trivia.utils.Res;

@RestController
public class TriviaController {

    @Autowired
    private TriviaService triviaService;

    @GetMapping("/get-questions")
    public ResponseEntity<?> getAllQuestions() {
        List<Question> questions = triviaService.fetchTriviaQuestions();
        return Res.renderJson(questions, "Question fetched successfully", HttpStatus.OK);
    }
    
}
