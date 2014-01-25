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

import java.util.List;

/**
 * Cette classe représente un game & watch.
 */
public class Jeu {
	private List<Sequence> sequences;
	private ContextJeu context;
	
	/**
	 * Crée un jeu.
	 */
	public Jeu() {
		context = new ContextJeu();
	}

	public List<Sequence> getSequences() {
		return sequences;
	}

	public ContextJeu getContext() {
		return context;
	}
	
	/**
	 * Joue un tour (= une transition) du jeu.
	 */
	public void jouerUnTour() {
		for(Sequence s: sequences) {
			s.suivant();
		}
	}
}
