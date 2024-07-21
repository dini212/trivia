package quiz.trivia.service;

import java.util.List;

import quiz.trivia.entity.Score;

public interface ScoreService {
    Score addScore(Integer userId, boolean correct);
    List<Score> getHighestScore();
    List<Score> getScore(Integer userId);
    boolean AnsweredQuestion(Score score);
}
