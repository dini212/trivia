package quiz.trivia.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import quiz.trivia.entity.Question;
import quiz.trivia.repository.QuestionRepository;
import quiz.trivia.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Question getRandomQuestion() {
       List<Question> questions = questionRepository.findAll();
       Random rand = new Random();
       return questions.get(rand.nextInt(questions.size()));
    }

    @Override
    public Question findById(String id) {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return question.get();   
    }
}
