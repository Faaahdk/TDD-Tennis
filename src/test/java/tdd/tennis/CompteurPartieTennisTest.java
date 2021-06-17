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
	public void test_nouvellePartie_choixJoueur1() {
		PartieDeTennis nouvellePartie = compteurPartieTennis.nouvellePartie(joueur1,joueur2);
		assertEquals(joueur1,nouvellePartie.getJoueur1());	
	}
	
	@Test
	@DisplayName("Un utilisateur peut créer une nouvelle partie en choissisant le joueur2")
	public void test_nouvellePartie_choixJoueur2() {
		PartieDeTennis nouvellePartie = compteurPartieTennis.nouvellePartie(joueur1,joueur2);
		assertEquals(joueur2,nouvellePartie.getJoueur2());	
	}
	
	@Test
	@DisplayName("Au début de la partie, le joueur1 a 0 point")
	public void test_nouvellePartie_zeroPointJoueur1() {
		PartieDeTennis nouvellePartie = compteurPartieTennis.nouvellePartie(joueur1,joueur2);
		assertEquals(0,nouvellePartie.getScoreJoueur1().getPoints());	
	}
	
	@Test
	@DisplayName("Au début de la partie, le joueur2 a 0 point")
	public void test_nouvellePartie_zeroPointJoueur2() {
		PartieDeTennis nouvellePartie = compteurPartieTennis.nouvellePartie(joueur1,joueur2);
		assertEquals(0,nouvellePartie.getScoreJoueur2().getPoints());	
	}

}
