package quiz.trivia.utils.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import quiz.trivia.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String name;

    public User convert() {
        return User.builder()
                    .name(name)
                    .build();
    }
}
