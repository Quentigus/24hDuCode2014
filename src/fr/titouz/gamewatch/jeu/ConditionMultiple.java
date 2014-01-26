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

public class ConditionMultiple extends ConditionComplexe {

	private static final long serialVersionUID = -2837408886956219125L;
	private OperateurLogiqueBinaire operateur;
	
	/**
	 * Crée une condition multiple
	 */
	public ConditionMultiple(OperateurLogiqueBinaire op) {
		operateur = op;
	}
	
	@Override
	public boolean add(Condition c) {
		operandes.add(c);
		return true;
	}

	/**
	 * Test si la condition est vrai.
	 * 
	 * @return true avec l'opérateur ET si tous les sous-conditions sont vrai, true avec l'opérateur OU si une sous-condition est vrai, sinon false.
	 */
	@Override
	public boolean isTrue() {
		if(operateur == OperateurLogiqueBinaire.ET) {
			for(Condition c : operandes) {
				if(c.isFalse()) {
					return false;
				}
			}
			return true;
		}
		else {//OR
			for(Condition c : operandes) {
				if(c.isTrue()) {
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * Test si la condition est fausse.
	 * 
	 * @return la négation de isTrue()
	 */
	@Override
	public boolean isFalse() {
		return !isTrue();
	}

	public OperateurLogiqueBinaire getOperateur() {
		return operateur;
	}

	public void setOperateur(OperateurLogiqueBinaire operateur) {
		this.operateur = operateur;
	}
}
