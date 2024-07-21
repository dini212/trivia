package quiz.trivia.utils.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import quiz.trivia.entity.Score;
import quiz.trivia.entity.User;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScoreResponse {

   private String name;

   private List<Score> scores;

   public static ScoreResponse response(User user) {
    return ScoreResponse.builder()
            .name(user.getName())
            .scores(user.getScores())
            .build();
   }
}
