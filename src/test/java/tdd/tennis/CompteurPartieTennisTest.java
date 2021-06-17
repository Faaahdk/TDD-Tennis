package tdd.tennis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompteurPartieTennisTest {
	
	
	static CompteurPartieTennis compteurPartieTennis = new CompteurPartieTennis();
	
	static JoueurDeTennis joueur1 = new JoueurDeTennis();
	static JoueurDeTennis joueur2 = new JoueurDeTennis();
	static PartieDeTennis nouvellePartie = new PartieDeTennis();
	
	@BeforeAll
	public static void initialisation_nouvellePartie() {
		nouvellePartie = compteurPartieTennis.nouvellePartie(joueur1,joueur2);
	}
	
	@Test
	@DisplayName("Un utilisateur peut cr�er une nouvelle partie en choissisant le joueur1")
	public void test_nouvellePartie_choixJoueur1() {
		assertEquals(joueur1,nouvellePartie.getJoueur1());	
	}
	
	@Test
	@DisplayName("Un utilisateur peut cr�er une nouvelle partie en choissisant le joueur2")
	public void test_nouvellePartie_choixJoueur2() {
		assertEquals(joueur2,nouvellePartie.getJoueur2());	
	}
	
	@Test
	@DisplayName("Au d�but de la partie, le joueur1 a 0 point")
	public void test_nouvellePartie_zeroPointJoueur1() {
		assertEquals(0,nouvellePartie.getScoreJoueur1().getPoints());	
	}
	
	@Test
	@DisplayName("Au d�but de la partie, le joueur2 a 0 point")
	public void test_nouvellePartie_zeroPointJoueur2() {
		assertEquals(0,nouvellePartie.getScoreJoueur2().getPoints());	
	}
	
	@Test
	@DisplayName("Au d�but de la partie, le joueur1 a 0 jeux gagn�s")
	public void test_nouvellePartie_zeroJeuxGagnesJoueur1() {
		assertEquals(0,nouvellePartie.getScoreJoueur1().getJeux());	
	}

	@Test
	@DisplayName("Au d�but de la partie, le joueur2 a 0 jeux gagn�s")
	public void test_nouvellePartie_zeroJeuxGagnesJoueur2() {
		assertEquals(0,nouvellePartie.getScoreJoueur2().getJeux());	
	}
	
	@Test
	@DisplayName("Au d�but de la partie, le joueur1 a 0 sets gagn�s")
	public void test_nouvellePartie_zeroSetsGagnesJoueur1() {
		assertEquals(0,nouvellePartie.getScoreJoueur1().getSet());	
	}

	@Test
	@DisplayName("Au d�but de la partie, le joueur2 a 0 sets gagn�s")
	public void test_nouvellePartie_zeroSetsGagnesJoueur2() {
		assertEquals(0,nouvellePartie.getScoreJoueur2().getSet());	
	}
	
	@Test
	@DisplayName("L'utilisateur peut notifier que le joueur1 a gagn� un point")
	public void test_joueur1GagneUnPoint() {
		compteurPartieTennis.joueurGagne(nouvellePartie, joueur1);
		assertEquals(15,nouvellePartie.getScoreJoueur1().getPoints());	
	}
	
	@Test
	@DisplayName("L'utilisateur peut notifier que le joueur2 a gagn� un point")
	public void test_joueur2GagneUnPoint() {
		compteurPartieTennis.joueurGagne(nouvellePartie, joueur2);
		assertEquals(15,nouvellePartie.getScoreJoueur2().getPoints());	
	}
}
