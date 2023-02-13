package bf.isge.gaming.quizz.ressource;

import bf.isge.gaming.quizz.domain.Choix;
import bf.isge.gaming.quizz.model.ChoixModel;
import bf.isge.gaming.quizz.model.PartieModel;
import bf.isge.gaming.quizz.service.ChoixService;
import bf.isge.gaming.quizz.service.PartieService;
import bf.isge.gaming.quizz.utils.DataMapping;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(value = "/api/choix")
@Slf4j
@AllArgsConstructor
public class ChoixRessource {
    private final ChoixService choixService;
    private final PartieService partieService;


    @GetMapping(value = "/{id}")
    ResponseEntity<List<ChoixModel>> find(@PathVariable Long id) {
        List<Choix> choixList = choixService.findByQuestionId(id);
        List<ChoixModel> result = new ArrayList<>();
        for (Choix choix : choixList) {
            result.add(DataMapping.toChoixModel(choix));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping("/add")
    ResponseEntity<HttpStatus> addChoix(@RequestParam(value = "idQuestion") Long idQuestion, @RequestBody Set<ChoixModel> choixModels) {
        log.info("Insertion de nouveaux choix : {}", choixModels.toString());
        Set<Choix> choix=new HashSet<>();
        for (ChoixModel choixModel: choixModels) {
            choix.add(DataMapping.fromChoixModel(choixModel));
        }
        choixService.addChoix(idQuestion, choix);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/answer")
    ResponseEntity answer(@RequestParam(value = "idQuestion") Long idPartie, @RequestBody Set<ChoixModel> choixModels) {
        List<ChoixModel> choix= new ArrayList<>();
        choixModels.forEach(choixModel -> choix.add(DataMapping.toChoixModel(choixService.find(choixModel.getId()))));
        AtomicInteger score= new AtomicInteger();
        choix.forEach(choix1 -> {if(choix1.isBonChoix()) score.getAndIncrement();});
        PartieModel partieModel= new PartieModel();
        partieModel.setId(idPartie);
        partieModel.setScore(score);
        partieService.update(DataMapping.fromPartieModel(partieModel));

        return ResponseEntity.status(HttpStatus.OK).body("Votre score est de "+ score);
    }
}
