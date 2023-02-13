package bf.isge.gaming.quizz.service;

import bf.isge.gaming.quizz.domain.Choix;
import bf.isge.gaming.quizz.domain.Question;
import bf.isge.gaming.quizz.repository.ChoixJpaRepository;
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
public class ChoixService {
    private final QuestionJpaRepository questionJpaRepository;
    private final ChoixJpaRepository choixJpaRepository;

    public Set<Choix> addChoix(Long idQuestion, Set <Choix> choix) {
        Question question= new Question();
        question.setId(idQuestion);
        choix.forEach(choix1 -> choix1.setQuestion(question));
        List<Choix> choixList = new ArrayList<>(choix);
        List<Choix> c = choixJpaRepository.saveAll(choixList);
        return new HashSet<>(c);
    }

    /*Methode permettant de récupérer un choix */
    public Choix find(Long id) {
        return choixJpaRepository.findById(id).orElse(null);
    }
}
