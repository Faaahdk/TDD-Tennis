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
			if(egalitePoints(partie,40)) {
				if(aucunAvantage(partie)) {
					partie.getScoreJoueur1().setAvantage(true);
				}else {
					if(partie.getScoreJoueur2().isAvantage()) {
						partie.getScoreJoueur2().setAvantage(false);
					}else {
						partie.getScoreJoueur1().setJeux(partie.getScoreJoueur1().getJeux()+1);
						reinitialiseScoreEtAvantage(partie);
					}
				}		
			}else {
				partie.getScoreJoueur1().marqueUnPoint();
			}
		}else if (gagnant == partie.getJoueur2()) {
			if(egalitePoints(partie,40)) {
				if(aucunAvantage(partie)) {
					partie.getScoreJoueur2().setAvantage(true);
				}else {
					if(partie.getScoreJoueur1().isAvantage()) {
						partie.getScoreJoueur1().setAvantage(false);
					}else {
						partie.getScoreJoueur2().setJeux(partie.getScoreJoueur2().getJeux()+1);
						reinitialiseScoreEtAvantage(partie);
					}	
				}		
			}else {
				partie.getScoreJoueur2().marqueUnPoint();
			}
		}
		return partie;
	}
	
	/**
	 * Cette méthode réinitialise les scores à 0 des joueurs et les avantages à false
	 * @param partie : partie qui est jouée
	 */
	public void reinitialiseScoreEtAvantage(PartieDeTennis partie) {
		partie.getScoreJoueur1().setPoints(0);
		partie.getScoreJoueur2().setPoints(0);
		partie.getScoreJoueur1().setAvantage(false);
		partie.getScoreJoueur2().setAvantage(false);
	}
	
	/**
	 * Cette méthode vérifie si les 2 joueurs sont à égalité en nombre de points et que le nombre de points vaut 40
	 * @param partie : partie qui est jouée
	 * @param nbPoints : nombre de points où l'égalité est testée
	 * @return True si les 2 joueurs sont à égalité, sinon false
	 */
	public boolean egalitePoints(PartieDeTennis partie, int nbPoints) {
		boolean result = false;
		if(partie.getScoreJoueur1().getPoints() == partie.getScoreJoueur2().getPoints() && partie.getScoreJoueur1().getPoints() == nbPoints) {
			result = true;
		}
		return result;
	}
	
	/**
	 * Cette méthode vérifie si les 2 joueurs n'ont pas d'avantage
	 * @param partie qui est jouée
	 * @return True si les 2 joueurs n'ont pas d'avantage, sinon false
	 */
	public boolean aucunAvantage(PartieDeTennis partie) {
		boolean result = false;
		if(!partie.getScoreJoueur1().isAvantage() && !partie.getScoreJoueur2().isAvantage()) {
			result = true;
		}
		return result;
	}
}
