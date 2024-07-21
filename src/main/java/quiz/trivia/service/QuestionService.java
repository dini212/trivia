package quiz.trivia.service;

import quiz.trivia.entity.Question;

public interface QuestionService {
    Question getRandomQuestion();
    Question findById(String id);
}
