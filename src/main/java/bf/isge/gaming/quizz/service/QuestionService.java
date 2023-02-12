package bf.isge.gaming.quizz.service;

import bf.isge.gaming.quizz.domain.Question;
import bf.isge.gaming.quizz.repository.QuestionJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class QuestionService {
    private final QuestionJpaRepository questionJpaRepository;

    /*Methode permettant de récupérer de toutes les questions */

    public Set<Question> find() {
        return new HashSet<>(questionJpaRepository.findAll());
    }
    /*Methode permettant de récupérer d'une question */
    public Question find(Long id) {
        return questionJpaRepository.findById(id).orElse(null);
    }


    /*Méthode permettant d'inserer une question */
    public void insert(Question question) {
        questionJpaRepository.save(question);
    }

    /* Méthode permettant de supprimer une question par son id */
    public void delete(Long id) {
        questionJpaRepository.deleteById(id);
    }

    /* Méthode permettant de modifier une question */
    public void update(Question updatedQuestion) {
        Question question= questionJpaRepository.findById(updatedQuestion.getId()).orElse(null);
        if(question!=null){
            question.setEnonce(updatedQuestion.getEnonce());
            questionJpaRepository.save(question);
        }

    }
    public List<Question> getRandom() {
        Set<Long> ids = questionJpaRepository.getRandom();
        List<Question> questions= new ArrayList<>();
        ids.forEach(id ->questions.add(questionJpaRepository.findWithChoix(id)));
        return questions;
    }


}
