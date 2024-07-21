package quiz.trivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.trivia.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
