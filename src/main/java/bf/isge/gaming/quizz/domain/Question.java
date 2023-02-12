package bf.isge.gaming.quizz.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "question")
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enonce;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "question_choix",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "choix_id")
    )
    private List<Choix> choix= new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "questions",fetch = FetchType.LAZY)
    private Set<Partie> parties= new HashSet<>();

}
