package tdd.tennis;
/**
 * Cette classe contient tout le code permettant de calculer les points au tennis.
 * @author Killian
 *
 */
public class CompteurPartieTennis {

	/**
	 * Cette méthode permet de créer une nouvelle partie de tennis.
	 * Une partie contient 2 joueurs et 2 Scores
	 * Au debut de la partie, les score sont a 0.
	 * @param joueur1 premier joueur de la partie
	 * @param joueur2 deuxieme joueur de la partie
	 * @return une nouvelle partie.
	 */
	public PartieDeTennis nouvellePartie(JoueurDeTennis joueur1, JoueurDeTennis joueur2) {
		ScoreTennis scoreJ1 = new ScoreTennis(0,0,0,0,false);
		ScoreTennis scoreJ2 = new ScoreTennis(0,0,0,0,false);
		PartieDeTennis nouvellePartie = new PartieDeTennis(joueur1,joueur2,scoreJ1,scoreJ2);
		return nouvellePartie;
	}
	
	/**
	 * Cette méthode doit être appelée lorsque un joueur gagne un point.
	 * @param partie qui est jouée.
	 * @param gagnant Joueur qui a gagné.
	 * @return La partie avec les nouveaux scores.
	 */
	public PartieDeTennis joueurGagne(PartieDeTennis partie, JoueurDeTennis gagnant) {
		if(gagnant == partie.getJoueur1()) {
			partie.getScoreJoueur1().marqueUnPoint();
		}else if (gagnant == partie.getJoueur2()) {
			partie.getScoreJoueur2().marqueUnPoint();
		}
		return partie;
	}
}
