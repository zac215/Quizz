package bf.isge.gaming.quizz.model;

import bf.isge.gaming.quizz.domain.Question;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@JsonSerialize
public class PartieModel {
    private Long id;
    private LocalDateTime dateCreation;
    private AtomicInteger score;

    private List<Question> questions= new ArrayList<>();
}
