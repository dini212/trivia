package quiz.trivia.utils.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import quiz.trivia.entity.Score;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerResponse {

    public int score;

    public String message;

    public static AnswerResponse response(Score score, String message) {
        return AnswerResponse.builder()
                .score(score.getScored())
                .message(message)
                .build();
    }
}
