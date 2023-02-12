package bf.isge.gaming.quizz.model;

import bf.isge.gaming.quizz.domain.Choix;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonSerialize
public class QuestionModel  {
    private Long id;
    private String enonce;
    List<Choix> choix= new ArrayList<>();

}
