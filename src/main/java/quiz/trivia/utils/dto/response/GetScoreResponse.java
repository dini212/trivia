package quiz.trivia.utils.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.*;
import quiz.trivia.entity.Score;
import quiz.trivia.entity.User;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetScoreResponse {

    private String name;

    private int totalScore;

    private int correctStreak;

    private int incorrectStreak;

    private LocalDateTime time;

    public static GetScoreResponse response(User user, List<Score> scores) {
        int totalScore = scores.stream().mapToInt(Score::getScored).sum();
        int correctStreak = scores.stream().mapToInt(Score::getCorrectStreak).sum();
        int incorrectStreak = scores.stream().mapToInt(Score::getIncorrectStreak).sum();

        LocalDateTime latestTime = scores.stream()
                                        .map(Score::getTime)
                                        .max(LocalDateTime::compareTo)
                                        .orElse(LocalDateTime.now());

        return GetScoreResponse.builder()
                .name(user.getName())
                .totalScore(totalScore)
                .correctStreak(correctStreak)
                .incorrectStreak(incorrectStreak)
                .time(latestTime)
                .build();
    }
}
