package quiz.trivia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import quiz.trivia.entity.Score;
import quiz.trivia.entity.User;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {

    List<Score> findTop5ByOrderByScoredDesc();

    List<Score> findByUserId(User user);
}
