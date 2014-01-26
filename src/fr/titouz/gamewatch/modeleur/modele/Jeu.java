package fr.titouz.gamewatch.modeleur.modele;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

public class Jeu implements Serializable {

	private static final long serialVersionUID = -3149764703072717787L;
	private static final Jeu instance = new Jeu();
	private BufferedImage fond;
	private ArrayList<Sprite> lesEnnemies;
	private ArrayList<Sprite> lesFixes;
	private ArrayList<Sprite> lesPersonnages;
	private ArrayList<Sequence> lesSequences;
	
	private ArrayList<BufferedImage> lesSpritesDecoupes;
	
	private Jeu() {
		this.lesEnnemies = new ArrayList<>();
		this.lesFixes = new ArrayList<>();
		this.lesPersonnages = new ArrayList<>();
		this.lesSequences = new ArrayList<>();
		this.lesSpritesDecoupes = new ArrayList<>();
	}
	
	public static Jeu getInstance() {
		return instance;
	}
	
	public BufferedImage getFond() {
		return fond;
	}
	
	public void setFond(BufferedImage fond) {
		this.fond = fond;
	}
	
	public ArrayList<Sprite> getLesEnnemies() {
		return lesEnnemies;
	}
	
	public void ajouterEnnemie(Sprite ennemie) {
		this.lesEnnemies.add(ennemie);
	}
	
	public ArrayList<Sprite> getLesFixes() {
		return lesFixes;
	}
	
	public void ajouterFixe(Sprite fixe) {
		this.lesFixes.add(fixe);
	}
	
	public ArrayList<Sprite> getLesPersonnages() {
		return lesPersonnages;
	}
	
	public void ajouterPersonnage(Sprite personnage) {
		this.lesPersonnages.add(personnage);
	}

	public ArrayList<Sequence> getLesSequences() {
		return lesSequences;
	}

	public void ajouterSequence(Sequence sequence) {
		this.lesSequences.add(sequence);
	}

	public ArrayList<BufferedImage> getLesSpritesDecoupes() {
		return lesSpritesDecoupes;
	}

	public void ajouterSpriteDecoupe(BufferedImage sprite) {
		this.lesSpritesDecoupes.add(sprite);
	}
}
