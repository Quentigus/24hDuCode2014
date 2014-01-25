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
 * You should have received a copy of the GNU General Public License along with <programm name>.  
 * If not, see <http://www.gnu.org/licenses/>.
 */

package fr.titouz.gamewatch.jeu;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class Sequence implements Serializable {
	private static final long serialVersionUID = 608080587374031553L;
	private Etat etatInitial;
	private List<Etat> etatsCourants;
	
	/**
	 * Crée une séquence.
	 * 
	 * @param init état initial de la séquence.
	 */
	public Sequence(Etat init) {
		super();
		etatsCourants = new LinkedList<Etat>();
		etatInitial = init;
	}

	public Etat getEtatInitial() {
		return etatInitial;
	}

	public void setEtatInitial(Etat etatInitial) {
		this.etatInitial = etatInitial;
	}
	
	public List<Etat> getEtatsCourants() {
		return etatsCourants;
	}
	
	/**
	 * Active toutes les transitions des états courant.
	 */
	public void suivant() {
		List<Etat> copie = new LinkedList<Etat>(etatsCourants);
		for(Etat e : copie) {
			for(Transition t : e) {
				t.suivant();
			}
		}
	}
}
