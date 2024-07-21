package quiz.trivia.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import quiz.trivia.entity.User;
import quiz.trivia.repository.ScoreRepository;
import quiz.trivia.repository.UserRepository;
import quiz.trivia.service.UserService;
import quiz.trivia.utils.dto.request.UserRequest;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired ScoreRepository scoreRepository;

    @Override
    public User create(UserRequest request) {
        User newUser = request.convert();
        return userRepository.saveAndFlush(newUser);
    }

     @Override
    public User getUser(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }
    
    @Override
    public User update(UserRequest request, Integer id) {
        Optional<User> sOptional = userRepository.findById(id);

        User user = sOptional.get();
        user.setName(request.getName());
        
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
       userRepository.deleteById(id);
    }

   
    
}
