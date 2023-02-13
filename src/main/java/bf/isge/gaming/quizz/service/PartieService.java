package bf.isge.gaming.quizz.service;

import bf.isge.gaming.quizz.domain.Partie;
import bf.isge.gaming.quizz.repository.PartieJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@AllArgsConstructor
public class PartieService {
    private final PartieJpaRepository partieJpaRepository;
    private final QuestionService questionService;

    public Partie generate() {
        Partie partie=new Partie();
        partie.setQuestions(questionService.getRandom());
        partie.setDateCreation(LocalDateTime.now());
        Partie insertedPartie= partieJpaRepository.save(partie);
        return partieJpaRepository.findWithQuestions(insertedPartie.getId());
        }

    public void update(Partie updatedPartie) {
        Partie partie= partieJpaRepository.findById(updatedPartie.getId()).orElse(null);
        if(partie!=null){
            partie.setScore(updatedPartie.getScore());
            partieJpaRepository.save(partie);
        }


    }}

