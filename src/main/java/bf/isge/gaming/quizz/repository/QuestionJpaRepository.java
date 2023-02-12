package bf.isge.gaming.quizz.repository;

import bf.isge.gaming.quizz.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface QuestionJpaRepository extends JpaRepository<Question, Long> {
    @Query(value = "SELECT q FROM  Question  q " +
            "join Choix "+

            "WHERE q.id=:id"
    )
    Question findWithChoix(@Param("id") Long id);

    @Query(nativeQuery = true, value = "SELECT id FROM question  ORDER BY random() LIMIT 5")
    Set<Long> getRandom();


}
