package quiz.trivia.service;

import quiz.trivia.entity.User;
import quiz.trivia.utils.dto.request.UserRequest;

public interface UserService {
    User create(UserRequest request);
    User getUser(Integer id);
    User update(UserRequest request, Integer id);
    void delete(Integer id);
}
