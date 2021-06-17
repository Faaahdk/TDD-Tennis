package tdd.tennis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompteurPartieTennisTest {
	
	CompteurPartieTennis compteurPartieTennis = new CompteurPartieTennis();
	
	JoueurDeTennis joueur1 = new JoueurDeTennis();
	JoueurDeTennis joueur2 = new JoueurDeTennis();
	
	@Test
	@DisplayName("Un utilisateur peut créer une nouvelle partie en choissisant le joueur1")
	public void test_nouvellePartie_retournePartieDeTennis() {
		PartieDeTennis nouvellePartie = compteurPartieTennis.nouvellePartie(joueur1,joueur2);
		assertEquals(joueur1,nouvellePartie.getJoueur1());	
	}

}
