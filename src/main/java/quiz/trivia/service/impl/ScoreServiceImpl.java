package quiz.trivia.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.trivia.entity.Score;
import quiz.trivia.entity.User;
import quiz.trivia.repository.ScoreRepository;
import quiz.trivia.repository.UserRepository;
import quiz.trivia.service.ScoreService;
import quiz.trivia.utils.dto.response.LeaderboardResponse;

@Service
public class ScoreServiceImpl implements ScoreService {
    
    @Autowired
    ScoreRepository scoreRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Score addScore(Integer userId, boolean correct) {
        
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        List<Score> scores = scoreRepository.findByUser(user);
        Score score;

    if (scores.isEmpty()) {
        score = new Score();
        score.setAnswered(0);
        score.setTime(LocalDateTime.now());
        score.setScored(0); 
        score.setCorrectStreak(0); 
        score.setIncorrectStreak(0); 
        score.setUser(user);

    } else {
        score = scores.get(0);
    }

    score.setAnswered(score.getAnswered() + 1);

    if (correct) {
        score.setCorrectStreak(score.getCorrectStreak() + 1);
        score.setScored(score.getScored() + score.getCorrectStreak());
        score.setIncorrectStreak(0);

    } else {
        score.setIncorrectStreak(score.getIncorrectStreak() + 1);
        score.setScored(score.getScored() - score.getIncorrectStreak());
        score.setCorrectStreak(0); 
    }

    score.setTime(LocalDateTime.now());

    Score savedScore = scoreRepository.save(score);

    return scoreRepository.save(savedScore);

    }

    @Override
    public List<Score> getScore(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return scoreRepository.findByUser(user);       
    }

    @Override
    public boolean AnsweredQuestion(Score score) {
       return score.getAnswered() >= 5;
    }

    @Override
    public List<LeaderboardResponse> getLeaderboard() {
       List<Score> scores = scoreRepository.findTop5ByOrderByScoredDesc();

       List<LeaderboardResponse> leaderboard = scores.stream()
            .sorted((s1, s2) -> Integer.compare(s2.getScored(), s1.getScored()))
            .map(score -> new LeaderboardResponse(
                scores.indexOf(score) + 1,
                score.getUser().getName(),
                score.getScored()
            ))
            .collect(Collectors.toList());

        return leaderboard;
    }
    
}
