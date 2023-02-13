package bf.isge.gaming.quizz.repository;

import bf.isge.gaming.quizz.domain.Choix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChoixJpaRepository extends JpaRepository<Choix, Long> {
    @Query(value = "SELECT c FROM  Choix c WHERE c.question.id=:id")
    List<Choix> findByQuestionId(@Param("id") Long id);
}
