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
import java.util.LinkedList;
import java.util.List;

/**
 * Cette classe représente les conditions composées d'autres conditions.
 */
public abstract class ConditionComplexe implements Condition, Serializable {
	private static final long serialVersionUID = 5305336783207588466L;
	protected List<Condition> operandes;
	
	/**
	 * Crée une condition complexe vide.
	 */
	public ConditionComplexe() {
		operandes = new LinkedList<Condition>();
	}
	
	/**
	 * Ajoute une sous-condition.
	 * 
	 * @param c la condiont à ajouter
	 * @return true si l'ajout est effectué, false dans le cas contraire
	 */
	public abstract boolean add(Condition c);
	
	/**
	 * Supprime une sous-condition.
	 * 
	 * @param c la condition à supprimer.
	 */
	public void remove(Condition c) {
		operandes.remove(c);
	}
	
	/**
	 * Supprime toute les sous--conditions.
	 */
	public void clear() {
		operandes.clear();
	}
	
	/**
	 * Test si la condition est vide.
	 * 
	 * @return true si la condition est vide, sinon false.
	 */
	public boolean isEmpty() {
		return operandes.isEmpty();
	}
	
	@Override
	public abstract boolean isTrue();

	@Override
	public abstract boolean isFalse();

}
