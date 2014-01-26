package fr.titouz.gamewatch.modeleur.modele;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

public class Jeu implements Serializable {

	private static final long serialVersionUID = -3149764703072717787L;
	private BufferedImage fond;
	private ArrayList<Sprite> lesEnnemies;
	private ArrayList<Sprite> lesFixes;
	private ArrayList<Sprite> lesPersonnages;
	private ArrayList<Sequence> lesSequences;
	
	public BufferedImage getFond() {
		return fond;
	}
	
	public void setFond(BufferedImage fond) {
		this.fond = fond;
	}
	
	public ArrayList<Sprite> getLesEnnemies() {
		return lesEnnemies;
	}
	
	public void setLesEnnemies(ArrayList<Sprite> lesEnnemies) {
		this.lesEnnemies = lesEnnemies;
	}
	
	public ArrayList<Sprite> getLesFixes() {
		return lesFixes;
	}
	
	public void setLesFixes(ArrayList<Sprite> lesFixes) {
		this.lesFixes = lesFixes;
	}
	
	public ArrayList<Sprite> getLesPersonnages() {
		return lesPersonnages;
	}
	
	public void setLesPersonnages(ArrayList<Sprite> lesPersonnages) {
		this.lesPersonnages = lesPersonnages;
	}
	
}
