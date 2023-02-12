package bf.isge.gaming.quizz.ressource;

import bf.isge.gaming.quizz.domain.Question;
import bf.isge.gaming.quizz.model.QuestionModel;
import bf.isge.gaming.quizz.service.QuestionService;
import bf.isge.gaming.quizz.utils.DataMapping;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/question")
@Slf4j
@AllArgsConstructor
public class QuestionRessource {
    private final QuestionService questionsService;

    @GetMapping
    ResponseEntity<List<QuestionModel>> findAll() {
        Set<Question> questions = questionsService.find();
        List<QuestionModel> result = new ArrayList<>();
        for (Question question : questions) {
            result.add(DataMapping.toQuestionModel(question));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<HttpStatus> insert(@RequestBody QuestionModel questionModel) {
        log.info("Insertion d'une nouvelle question : {}", questionModel.getEnonce());
        questionsService.insert(DataMapping.fromQuestionModel(questionModel));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<HttpStatus> update(@RequestBody QuestionModel questionModel) {
        log.info("Mise à jour des informations du livre : {}", questionModel.getEnonce());
        questionsService.update(DataMapping.fromQuestionModel(questionModel));
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping(value = "/{id}")
    ResponseEntity<QuestionModel> find(@PathVariable(value = "id") Long id) {
        log.info("Récupération de la question : {}", id);
        Question question = questionsService.find(id);
        return new ResponseEntity<>(DataMapping.toQuestionModel(question), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<HttpStatus> delete(@PathVariable(value = "id") Long id) {
        log.info("Suppression de la question d'Id : {} ", id);
        questionsService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
