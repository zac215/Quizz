package bf.isge.gaming.quizz.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "choix")
@Getter
@Setter
public class Choix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChoix;
    private String designation;
    private boolean bonChoix;
    @ManyToMany(mappedBy = "choix")
    private Set<Partie> parties= new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private  Question question;

}
