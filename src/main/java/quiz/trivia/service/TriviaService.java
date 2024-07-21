package quiz.trivia.service;

import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import quiz.trivia.entity.Question;
import quiz.trivia.repository.QuestionRepository;
import quiz.trivia.utils.dto.response.TriviaResponse;
import reactor.core.publisher.Mono;

@Service
public class TriviaService {

    private final WebClient webClient;
    private final QuestionRepository questionRepository;

    public TriviaService(QuestionRepository questionRepository) {
       this.questionRepository = questionRepository;
       this.webClient = WebClient.builder()
                .baseUrl("https://opentdb.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public List<Question> fetchTriviaQuestions() {
        Mono<TriviaResponse> responseMono = webClient.get()
            .uri("/api.php?amount=20&type=boolean")
            .retrieve()
            .bodyToMono(TriviaResponse.class);
        
        TriviaResponse response = responseMono.block();
        List<Question> questions = response.getResults();

        for(Question question : questions) {
            questionRepository.save(question);
        }

        return questions;

    }
    
}
