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

import java.io.File;
import java.util.List;

import fr.titouz.gamewatch.emulateur.view.MainPanel;
import fr.titouz.gamewatch.emulateur.view.common.CenterPanel;
import fr.titouz.gamewatch.emulateur.view.game.GameTitlePanel;
import fr.titouz.gamewatch.tools.Repertoire;

public class ControlController {

	private static ControlController instance;

	private ControlController() {
	}

	public static synchronized ControlController getInstance() {
		if (null == instance) {
			instance = new ControlController();
		}
		return instance;
	}
	
	public String[] getListGames() {
		List<String> list = Repertoire.getListeFichiers();
		String[] games = new String[list.size()];
		list.toArray(games);
		
		return games;
	}

	public void enterListControl(String selectedValue) {
		if(selectedValue != null && !MainController.getInstance().isGameOn()) {
			String url = "C:\\"+selectedValue.replaceAll(" ", "_")+".titz";
			chargerJeu(url);
			MainController.getInstance().launchGame();
			CenterPanel.getInstance().changerEcranToGame();
		}
		
	}
	
	private void chargerJeu(String url) {
		File f = new File(url);
		
	}

	public void rightControl() {
		if(MainController.getInstance().isGameOn()) {
			System.out.println("right");
		}
	}
	
	public void leftControl() {
		if(MainController.getInstance().isGameOn()) {
			System.out.println("left");
		}
	}

	public void upControl() {
		if(MainController.getInstance().isGameOn()) {
			System.out.println("up");
		}
	}
	
	public void downControl() {
		if(MainController.getInstance().isGameOn()) {
			System.out.println("down");
		}
	}
}
