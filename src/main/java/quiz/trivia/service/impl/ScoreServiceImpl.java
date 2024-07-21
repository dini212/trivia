package quiz.trivia.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quiz.trivia.entity.Score;
import quiz.trivia.entity.User;
import quiz.trivia.repository.ScoreRepository;
import quiz.trivia.repository.UserRepository;
import quiz.trivia.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    ScoreRepository scoreRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Score addScore(Integer userId, boolean correct) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        List<Score> scores = scoreRepository.findTop5ByOrderByScoredDesc();
        Score score;

    if (scores.isEmpty()) {
        score = new Score();
        score.setUserId(user);
        score.setTime(LocalDateTime.now());
        score.setScored(0); 
        score.setCorrectStreak(0); 
        score.setIncorrectStreak(0); 

    } else {
        score = scores.get(0); 
    }

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

    return scoreRepository.save(score);
}

    @Override
    public List<Score> getHighestScore() {
        return scoreRepository.findTop5ByOrderByScoredDesc();
    }

    @Override
    public List<Score> getScore(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return scoreRepository.findByUserId(user);
                
    }

    @Override
    public boolean AnsweredQuestion(Score score) {
       return score.getAnswered() >= 10;
    }
    
}
