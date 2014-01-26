/*Copyright ANDRU Bastien, CARRE, Gaël DUROY Adrien, GOSSELIN Quentin, JARROT Kathleen
 * (25/01/2014)
 * This file is part of Titz & Watch.
 * 
 * Titz & Watch is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * Titz & Watch is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with Titz & Watch.  
 * If not, see <http://www.gnu.org/licenses/>.
 */

package fr.titouz.gamewatch.modeleur.modele;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

public class Jeu implements Serializable {

	private static final long serialVersionUID = -3149764703072717787L;
	private static final Jeu instance = new Jeu();
	private BufferedImage fond;
	private String nom;
	private ArrayList<Sprite> lesEnnemies;
	private ArrayList<Sprite> lesFixes;
	private ArrayList<Sprite> lesPersonnages;
	private ArrayList<GTransition> lesSequences;
	
	public String getNom()  {
		return nom;
	}
	
	public void setString(String nom) {
		this.nom = nom;
	}
	
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
