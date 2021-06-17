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
	@DisplayName("Un utilisateur peut créer une nouvelle partie")
	public void test_creationPartieAvec2Joueurs() {
		assertNotNull(nouvellePartie);
	}
	
	@Test
	@DisplayName("Un utilisateur peut créer une nouvelle partie en choissisant le joueur1")
	public void test_nouvellePartie_choixJoueur1() {
		assertEquals(joueur1,nouvellePartie.getJoueur1());	
	}
	
	@Test
	@DisplayName("Un utilisateur peut créer une nouvelle partie en choissisant le joueur2")
	public void test_nouvellePartie_choixJoueur2() {
		assertEquals(joueur2,nouvellePartie.getJoueur2());	
	}
	
	@Test
	@DisplayName("Au début de la partie, le joueur1 a 0 point")
	public void test_nouvellePartie_zeroPointJoueur1() {
		assertEquals(0,nouvellePartie.getScoreJoueur1().getPoints());	
	}
	
	@Test
	@DisplayName("Au début de la partie, le joueur2 a 0 point")
	public void test_nouvellePartie_zeroPointJoueur2() {
		assertEquals(0,nouvellePartie.getScoreJoueur2().getPoints());	
	}
	
	@Test
	@DisplayName("Au début de la partie, le joueur1 a 0 jeux gagnés")
	public void test_nouvellePartie_zeroJeuxGagnesJoueur1() {
		assertEquals(0,nouvellePartie.getScoreJoueur1().getJeux());	
	}

	@Test
	@DisplayName("Au début de la partie, le joueur2 a 0 jeux gagnés")
	public void test_nouvellePartie_zeroJeuxGagnesJoueur2() {
		assertEquals(0,nouvellePartie.getScoreJoueur2().getJeux());	
	}
	
	@Test
	@DisplayName("Au début de la partie, le joueur1 a 0 sets gagnés")
	public void test_nouvellePartie_zeroSetsGagnesJoueur1() {
		assertEquals(0,nouvellePartie.getScoreJoueur1().getSet());	
	}

	@Test
	@DisplayName("Au début de la partie, le joueur2 a 0 sets gagnés")
	public void test_nouvellePartie_zeroSetsGagnesJoueur2() {
		assertEquals(0,nouvellePartie.getScoreJoueur2().getSet());	
	}
	
	@Test
	@DisplayName("L'utilisateur peut notifier que le joueur1 a gagné un point")
	public void test_joueur1GagneUnPoint() {
		compteurPartieTennis.joueurGagne(nouvellePartie, joueur1);
		assertEquals(15,nouvellePartie.getScoreJoueur1().getPoints());	
	}
	
	@Test
	@DisplayName("L'utilisateur peut notifier que le joueur2 a gagné un point")
	public void test_joueur2GagneUnPoint() {
		compteurPartieTennis.joueurGagne(nouvellePartie, joueur2);
		assertEquals(15,nouvellePartie.getScoreJoueur2().getPoints());	
	}
	
	@Test
	@DisplayName("Si les deux joueurs sont à égalité à 40 points, si aucun joueur a un avantage, le joueur1 qui gagne le point gagne un avantage")
	public void test_joueur1MarquePointEnGagnantUnAvantage() {
		nouvellePartie.getScoreJoueur1().setPoints(40);
		nouvellePartie.getScoreJoueur2().setPoints(40);
		compteurPartieTennis.joueurGagne(nouvellePartie, joueur1);
		assertEquals(true,nouvellePartie.getScoreJoueur1().isAvantage());
		nouvellePartie.getScoreJoueur1().setAvantage(false);
	}
	
	@Test
	@DisplayName("Si les deux joueurs sont à égalité à 40 points, si aucun joueur a un avantage, le joueur2 qui gagne le point gagne un avantage")
	public void test_joueur2MarquePointEnGagnantUnAvantage() {
		nouvellePartie.getScoreJoueur1().setPoints(40);
		nouvellePartie.getScoreJoueur2().setPoints(40);
		compteurPartieTennis.joueurGagne(nouvellePartie, joueur2);
		assertEquals(true,nouvellePartie.getScoreJoueur2().isAvantage());
		nouvellePartie.getScoreJoueur2().setAvantage(false);
	}
	
	@Test
	@DisplayName("Si les deux joueurs sont à égalité à 40 points, le joueur1 qui gagne le point et qui a un avantage, gagne un jeu")
	public void test_joueur1MarquePointAvecAvantageGagneUnJeu() {
		nouvellePartie.getScoreJoueur1().setPoints(40);
		nouvellePartie.getScoreJoueur1().setAvantage(true);
		nouvellePartie.getScoreJoueur2().setPoints(40);
		compteurPartieTennis.joueurGagne(nouvellePartie, joueur1);
		assertEquals(1,nouvellePartie.getScoreJoueur1().getJeux());
	}
	
	@Test
	@DisplayName("Si les deux joueurs sont à égalité à 40 points, le joueur2 qui gagne le point et qui a un avantage, gagne un jeu")
	public void test_joueur2MarquePointAvecAvantageGagneUnJeu() {
		nouvellePartie.getScoreJoueur1().setPoints(40);
		nouvellePartie.getScoreJoueur2().setAvantage(true);
		nouvellePartie.getScoreJoueur2().setPoints(40);
		compteurPartieTennis.joueurGagne(nouvellePartie, joueur2);
		assertEquals(1,nouvellePartie.getScoreJoueur2().getJeux());
	}
	
}
