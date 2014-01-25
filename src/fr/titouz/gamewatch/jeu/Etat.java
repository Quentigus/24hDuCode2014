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

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

/**
 * Cette classe représente un état d'une séquence. 
 */
public class Etat implements Iterable<Transition> {
	private List<Transition> transitions;
	private boolean actif;
	
	/**
	 * Crée un état sans transition et désactivé.
	 */
	public Etat() {
		this(false);
	}
	
	/**
	 * Crée un état.
	 * 
	 * @param active booléen indiquant si l'état doit être actif par défaut.
	 */
	public Etat(boolean active) {
		transitions = new LinkedList<Transition>();
		actif = active;
	}
	
	/**
	 * Ajoute une nouvelle transition à l'état.
	 * 
	 * @param t la nouvelle transition.
	 */
	public void add(Transition t) {
		transitions.add(t);
	}
	
	/**
	 * Supprime une transition de l'état.
	 * 
	 * @param t la transition à supprimer.
	 */
	public void remove(Transition t) {
		transitions.remove(t);
	}
	
	/**
	 * Supprime une transition de l'état.
	 * 
	 * @param index l'index de la transition à supprimer.
	 */
	public void remove(int index) {
		transitions.remove(index);
	}
	
	/**
	 * Insert une nouvelle transition dans l'état.
	 * 
	 * @param t la nouvelle transition.
	 * @param index la place à laquelle inséré la transition
	 */
	public void add(int index, Transition t) {
		transitions.add(index, t);
	}
	
	/**
	 * Intervertit deux transitions.
	 * 
	 * @param index1 la place de la première transition.
	 * @param index2 la place de la transition avec laquelle échanger.
	 */
	public void intervertir(int index1, int index2) {
		if(index1 != index2) {
			Transition t1 = transitions.get(index1);
			Transition t2 = transitions.get(index2);
			transitions.remove(t1);
			transitions.remove(t2);
			if(index1 < index2) {
				transitions.add(index1, t2);
				transitions.add(index2, t1);
			}
		}
	}

	@Override
	public Iterator<Transition> iterator() {
		return transitions.iterator();
	}
	
	/**
	 * Obtenir une transition de l'état.
	 * 
	 * @param index la place de la transition.
	 * @return
	 */
	public Transition get(int index) {
		return transitions.get(index);
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}
}
