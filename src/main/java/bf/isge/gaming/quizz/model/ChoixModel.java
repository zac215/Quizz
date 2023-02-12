package bf.isge.gaming.quizz.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@JsonSerialize
@Getter
@Setter
public class ChoixModel implements Serializable {
    private Long id;
    private String designation;
    private boolean bonChoix;
}
