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

package fr.titouz.gamewatch.jeu;

import java.io.Serializable;

/**
 * Cette classe repr�sente une condition sur un �tat.
 */
public class ConditionEtat implements Condition, Serializable {
	private static final long serialVersionUID = 2543076887634725170L;
	private Etat etat;
	
	/**
	 * Cr�e une condition d'�tat.
	 * @param etat
	 */
	public ConditionEtat(Etat etat) {
		this.etat = etat;
	}
	
	/**
	 * Test si la condition est vrai.
	 * 
	 * @return true si l'�tat est actif, false dans le cas contraire.
	 */
	@Override
	public boolean isTrue() {
		return etat.isActif();
	}

	/**
	 * Test si la condition est fausse.
	 * 
	 * @return false si l'�tat est actif, true dans le cas contraire.
	 */
	@Override
	public boolean isFalse() {
		return !isTrue();
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

}
