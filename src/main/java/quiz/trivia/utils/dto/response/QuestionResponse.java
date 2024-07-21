package quiz.trivia.utils.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import quiz.trivia.entity.Question;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionResponse {

    private String id;

    private String category;

    private String question;

    public static QuestionResponse response(Question question) {
        return QuestionResponse.builder()
                .id(question.getId())
                .category(question.getCategory())
                .question(question.getQuestion())
                .build();
    }
}
