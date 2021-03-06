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

import java.io.Serializable;

/**
 * Cette classe représente graphiquement une transition.
 * TODO A déplacer dans le package des vues. Revoir sa conception.
 */
public class GTransition implements Serializable {

	private static final long serialVersionUID = 5596002822836246892L;
	private Sprite initial;
	private Sprite destination;
	private String condition;
	
	public GTransition(Sprite pInitial, Sprite pDestination, String pCondition) {
		this.initial = pInitial;
		this.destination = pDestination;
		this.condition = pCondition;
	}

	public Sprite getInitial() {
		return initial;
	}

	public Sprite getDestination() {
		return destination;
	}

	public String getCondition() {
		return condition;
	}
}
