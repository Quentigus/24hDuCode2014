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

/**
 * Cette classe représente une condition négative.
 */
public class NonCondition extends ConditionComplexe {

	private static final long serialVersionUID = -8139156362516597042L;

	@Override
	public boolean add(Condition c) {
		if(operandes.size() >= 1)
			return false;
		operandes.add(c);
		return true;
	}

	/**
	 * Test si la condition est vrai.
	 * 
	 * @return true si la sous-condition est fausse, false dans le cas contraire ou si la condition est vide.
	 */
	@Override
	public boolean isTrue() {
		if(operandes.size() == 1)
			return operandes.get(0).isFalse();
		return false;
	}

	/**
	 * Test si la condition est fausse.
	 * 
	 * @return false si la sous-condition est fausse, true dans le cas contraire ou si la condition est vide.
	 */
	@Override
	public boolean isFalse() {
		if(operandes.size() == 1)
			return operandes.get(0).isTrue();
		return true;
	}

}
