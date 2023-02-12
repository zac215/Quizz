package bf.isge.gaming.quizz.ressource;

import bf.isge.gaming.quizz.domain.Choix;
import bf.isge.gaming.quizz.model.ChoixModel;
import bf.isge.gaming.quizz.service.ChoixService;
import bf.isge.gaming.quizz.utils.DataMapping;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/choix")
@Slf4j
@AllArgsConstructor
public class ChoixRessource {
    private final ChoixService choixService;

    @PostMapping
    ResponseEntity<HttpStatus> addChoix(@RequestParam(value = "idQuestion") Long idQuestion, @RequestBody Set<ChoixModel> choixModels) {
        log.info("Insertion de nouveaux choix : {}", choixModels.toString());
        Set<Choix> choix=new HashSet<>();
        for (ChoixModel choixModel: choixModels) {
            choix.add(DataMapping.fromChoixModel(choixModel));
        }
        choixService.addChoix(idQuestion, choix);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
