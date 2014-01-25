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

import java.util.LinkedList;
import java.util.List;

/**
 * Cette classe représente une transition disponible entre des états du jeu.
 */
public abstract class Transition {

	protected Etat etatEntree;
	protected List<Etat> etatSortie;
	protected ContextJeu contextDuJeu;
	protected Sequence sequence;
	
	public Transition(ContextJeu context, Sequence s, Etat entree) {
		contextDuJeu = context;
		sequence = s;
		etatSortie = new LinkedList<Etat>();
		etatEntree = entree;
	}
	
	public Etat getEtatEntree() {
		return etatEntree;
	}

	public void setEtatEntree(Etat etatEntree) {
		this.etatEntree = etatEntree;
	}

	public List<Etat> getEtatSortie() {
		return etatSortie;
	}

	public Sequence getSequence() {
		return sequence;
	}

	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}

	public ContextJeu getContextDuJeu() {
		return contextDuJeu;
	}

	public void setContextDuJeu(ContextJeu contextDuJeu) {
		this.contextDuJeu = contextDuJeu;
	}

	/**
	 * Action effectuée par la transition à chaque tour.
	 */
	public abstract void suivant();
}
