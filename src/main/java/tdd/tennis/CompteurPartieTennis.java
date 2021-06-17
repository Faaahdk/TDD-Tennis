package tdd.tennis;
/**
 * Cette classe contient tout le code permettant de calculer les points au tennis.
 * @author Killian
 *
 */
public class CompteurPartieTennis {

	/**
	 * Cette m�thode permet de cr�er une nouvelle partie de tennis.
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
	 * Cette m�thode doit �tre appel�e lorsque un joueur gagne un point.
	 * @param partie qui est jou�e.
	 * @param gagnant Joueur qui a gagn�.
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
	 * Cette m�thode r�initialise les scores � 0 des joueurs et les avantages � false
	 * @param partie : partie qui est jou�e
	 */
	public void reinitialiseScoreEtAvantage(PartieDeTennis partie) {
		partie.getScoreJoueur1().setPoints(0);
		partie.getScoreJoueur2().setPoints(0);
		partie.getScoreJoueur1().setAvantage(false);
		partie.getScoreJoueur2().setAvantage(false);
	}
	
	/**
	 * Cette m�thode v�rifie si les 2 joueurs sont � �galit� en nombre de points et que le nombre de points vaut 40
	 * @param partie : partie qui est jou�e
	 * @param nbPoints : nombre de points o� l'�galit� est test�e
	 * @return True si les 2 joueurs sont � �galit�, sinon false
	 */
	public boolean egalitePoints(PartieDeTennis partie, int nbPoints) {
		boolean result = false;
		if(partie.getScoreJoueur1().getPoints() == partie.getScoreJoueur2().getPoints() && partie.getScoreJoueur1().getPoints() == nbPoints) {
			result = true;
		}
		return result;
	}
	
	/**
	 * Cette m�thode v�rifie si les 2 joueurs n'ont pas d'avantage
	 * @param partie qui est jou�e
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
