package quiz.trivia.service;

import java.util.List;

import quiz.trivia.entity.Score;
import quiz.trivia.utils.dto.response.LeaderboardResponse;

public interface ScoreService {
    Score addScore(Integer userId, boolean correct);
    List<Score> getScore(Integer userId);
    boolean AnsweredQuestion(Score score);
    List<LeaderboardResponse> getLeaderboard();
}
