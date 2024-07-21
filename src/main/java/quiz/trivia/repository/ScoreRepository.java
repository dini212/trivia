package quiz.trivia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import quiz.trivia.entity.Score;
import quiz.trivia.entity.User;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {

    @Query("SELECT s FROM Score s JOIN FETCH s.user ORDER BY s.scored DESC LIMIT 5")
    List<Score> findTop5ByOrderByScoredDesc();

    List<Score> findByUser(User user);
}
