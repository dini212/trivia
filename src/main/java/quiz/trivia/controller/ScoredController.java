package quiz.trivia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import quiz.trivia.entity.Score;
import quiz.trivia.entity.User;
import quiz.trivia.service.ScoreService;
import quiz.trivia.service.UserService;
import quiz.trivia.utils.Res;
import quiz.trivia.utils.dto.response.GetScoreResponse;

@RestController
@RequestMapping("/scores")
public class ScoredController {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserScore(@PathVariable Integer userId) {
        List<Score> scores = scoreService.getScore(userId);
        User user = userService.getUser(userId);
        GetScoreResponse response = GetScoreResponse.response(user, scores);
        return Res.renderJson(response, "data found", HttpStatus.OK);
    }

    @GetMapping("/leaderboard")
    public ResponseEntity<?> getLeaderboard() {
        List<Score> scores = scoreService.getHighestScore();
        return Res.renderJson(scores, "Leaderboard successfully made", HttpStatus.OK);
    }
    
}
