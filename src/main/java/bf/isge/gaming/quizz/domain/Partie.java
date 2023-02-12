package bf.isge.gaming.quizz.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "partie")
@Getter
@Setter

public class Partie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateCreation;
    private int score;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "reponse",
            joinColumns = @JoinColumn(name = "partie_id"),
            inverseJoinColumns = @JoinColumn(name = "choix_id")
    )
    Set<Choix> choix;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "partie_question",
            joinColumns = @JoinColumn(name = "partie_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions= new ArrayList<>();

    @ManyToOne
    private Utilisateur utilisateur;
}
