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

package fr.titouz.gamewatch.emulateur.controller;

import fr.titouz.gamewatch.emulateur.view.MainFrame;
import fr.titouz.gamewatch.modeleur.modele.Jeu;

public class MainController {
	
	private static MainController instance;
	private boolean gameIsOn = false;
	private Jeu jeuCourant;

	private MainController() {
	}

	public static synchronized MainController getInstance() {
		if (null == instance) {
			instance = new MainController();
		}
		return instance;
	}
	
	public MainController init() {
		
		MainFrame.getInstance().init();
		
		return this;
	}
	
	public boolean isGameOn() {
		return this.gameIsOn;
	}

	public void launchGame(Jeu jeu) {
		// TODO Auto-generated method stub
		this.gameIsOn = true;
		this.jeuCourant = jeu;
	}

	public Jeu getJeu() {
		// TODO Auto-generated method stub
		return jeuCourant;
	}
	

}
