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

package fr.titouz.gamewatch.jeu.transitions;

import fr.titouz.gamewatch.jeu.ContextJeu;
import fr.titouz.gamewatch.jeu.Etat;
import fr.titouz.gamewatch.jeu.Sequence;
import fr.titouz.gamewatch.jeu.Transition;

public class TransitionVenirDe extends Transition{

	private static final long serialVersionUID = 151994481991207960L;
	private Etat etatTest;

	public TransitionVenirDe(ContextJeu context, Sequence s, Etat entree) {
		super(context, s, entree);
	}

	@Override
	public void suivant() {
		if(this.etatEntree.getAncienEtat() == etatTest) {
			this.etatEntree.setActif(false);
			this.sequence.getEtatsCourants().remove(etatEntree);
			for(Etat e: this.etatSortie) {
				e.setActif(true);
				e.setAncienEtat(etatEntree);
				this.sequence.getEtatsCourants().add(e);
			}
		}
		
	}

	public Etat getEtatTest() {
		return etatTest;
	}

	public void setEtatTest(Etat etatTest) {
		this.etatTest = etatTest;
	}
	

}
