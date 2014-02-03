/* Copyright ANDRU Bastien, CARRE, Gaël DUROY Adrien, GOSSELIN Quentin, JARROT Kathleen
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
 * Énumération des touches disponibles pour les jeux.
 */
public enum Touche {
	DROITE, GAUCHE, HAUT, BAS;
	
	@Override
	public String toString() {
		switch(this) {
			case DROITE:
				return "droite";
			case GAUCHE:
				return "gauche";
			case HAUT:
				return "haut";
			default:
				return "bas";
		}
	}
}
