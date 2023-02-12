package bf.isge.gaming.quizz.repository;

import bf.isge.gaming.quizz.domain.Partie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PartieJpaRepository extends JpaRepository<Partie, Long> {
    @Query(value = "SELECT p FROM  Partie  p " +
            "join Question "+

            "WHERE p.id=:id"
    )
    Partie findWithQuestions(@Param("id") Long id);

}
