package quiz.trivia.utils.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import quiz.trivia.entity.Question;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TriviaResponse {
    
    private List<Question> results;
}
