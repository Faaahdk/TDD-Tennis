package tdd.tennis;

/**
 * Représente le score d'un joueur de tennis.
 * @author Killian
 *
 */
public class ScoreTennis {
	private int points;
	private int jeux;
	private int set;
	private int match;
	
	public ScoreTennis(int points, int jeux, int set, int match) {
		super();
		this.points = points;
		this.jeux = jeux;
		this.set = set;
		this.match = match;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public int getJeux() {
		return jeux;
	}
	
	public void setJeux(int jeux) {
		this.jeux = jeux;
	}
	
	public int getSet() {
		return set;
	}
	
	public void setSet(int set) {
		this.set = set;
	}
	
	public int getMatch() {
		return match;
	}
	
	public void setMatch(int match) {
		this.match = match;
	}
	
	public void marqueUnPoint() {
		if(this.points != 40) {
			this.points += 15;
		}else {
			this.points = 0;
		}
	}
}
