package bf.isge.gaming.quizz.service;

import bf.isge.gaming.quizz.domain.Utilisateur;
import bf.isge.gaming.quizz.repository.UtilisateurJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurDetailsService implements UserDetailsService {

	@Autowired
	private UtilisateurJpaRepository utilisateurRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

			Utilisateur utilisateur = utilisateurRepository.findByUsername(username);

			if(utilisateur == null) {
				throw new UsernameNotFoundException("User not found!");
			}

			return  utilisateur;

	}

}
