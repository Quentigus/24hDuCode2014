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
	private BufferedImage fond;
	private ArrayList<Sprite> lesEnnemies;
	private ArrayList<Sprite> lesFixes;
	private ArrayList<Sprite> lesPersonnages;
	private ArrayList<GTransition> lesSequences;
	
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
