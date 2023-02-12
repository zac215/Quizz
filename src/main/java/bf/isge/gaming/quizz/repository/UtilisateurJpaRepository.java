package bf.isge.gaming.quizz.repository;

import bf.isge.gaming.quizz.domain.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurJpaRepository extends JpaRepository<Utilisateur, Long> {

	Utilisateur findByUsername(String username);

}
