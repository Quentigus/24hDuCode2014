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

package fr.titouz.gamewatch.jeu;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Cette classe contient l'état des éléments généraux d'un jeu.
 */
public class ContextJeu implements Serializable {
	private static final long serialVersionUID = 7979879589240342453L;
	private Map<String, Boolean> etatsTouches;
	
	public ContextJeu() {
		etatsTouches = new HashMap<String, Boolean>();
		initTouchMap();
	}
	
	private void initTouchMap() {
		etatsTouches.put("droite", false);
		etatsTouches.put("gauche", false);
	}

	public Map<String, Boolean> getEtatsTouches() {
		return etatsTouches;
	}

	public void setEtatsTouches(Map<String, Boolean> etatsTouches) {
		this.etatsTouches = etatsTouches;
	}
}
