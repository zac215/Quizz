package bf.isge.gaming.quizz.ressource;

import bf.isge.gaming.quizz.model.PartieModel;
import bf.isge.gaming.quizz.service.PartieService;
import bf.isge.gaming.quizz.utils.DataMapping;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/partie")
@Slf4j
@AllArgsConstructor
public class PartieRessource {
    private final PartieService partieService;

    @GetMapping
    ResponseEntity<PartieModel> generate() {
        PartieModel partieModel= DataMapping.toPartieModel(partieService.generate());
        return new ResponseEntity<>(partieModel, HttpStatus.OK);
    }


}
