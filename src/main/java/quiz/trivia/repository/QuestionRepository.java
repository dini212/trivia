package quiz.trivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.trivia.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
    
}
