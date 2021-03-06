/*Copyright ANDRU Bastien, CARRE, Ga�l DUROY Adrien, GOSSELIN Quentin, JARROT Kathleen
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

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import fr.titouz.gamewatch.jeu.Etat;
import fr.titouz.gamewatch.tools.ImageSerialisable2;

/**
 * Cette classe représente une image du jeu dont l'état peut varier.
 */
public class Sprite implements Serializable {

	private static final long serialVersionUID = 8449098848147438233L;
	private Point coordonnees;
	private ImageSerialisable2 image;
	private Etat etat;
	
	public Sprite(Point coordonnees, BufferedImage image) {
		this.coordonnees = coordonnees;
		this.image = new ImageSerialisable2(image);
		this.etat = null;
	}

	public Point getCoordonnees() {
		return coordonnees;
	}

	public BufferedImage getImage() {
		return this.image.get();
	}
	
	/**
	 * Indique si le sprite doit �tre affich�. Cela dépend de son état.
	 * 
	 * @return true si le sprite doit �tre affich�, sinon false.
	 */
	public boolean isVisible() {
		if(this.etat == null) {
			return true;
		}
		return etat.isActif();
	}

	/**
	 * Test si le sprite est associé à un état.
	 * 
	 * @return <code>true</code> si le sprite est associé à un état, <code>false</code> dans le cas contraire.
	 */
	public boolean hasEtat() {
		return etat != null;
	}
	
	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	public void setCoordonnees(Point coordonnees) {
		this.coordonnees = coordonnees;
	}
}
