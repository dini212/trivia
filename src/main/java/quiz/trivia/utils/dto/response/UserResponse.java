package quiz.trivia.utils.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import quiz.trivia.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private int id; 

    private String name;

    public static UserResponse response(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
    
}
