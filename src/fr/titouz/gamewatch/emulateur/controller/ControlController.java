/*Copyright ANDRU Bastien, CARRE, Ga�l DUROY Adrien, GOSSELIN Quentin, JARROT Kathleen
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import fr.titouz.gamewatch.emulateur.view.MainPanel;
import fr.titouz.gamewatch.emulateur.view.common.CenterPanel;
import fr.titouz.gamewatch.emulateur.view.game.GamePanel;
import fr.titouz.gamewatch.emulateur.view.game.GameTitlePanel;
import fr.titouz.gamewatch.jeu.Touche;
import fr.titouz.gamewatch.modeleur.modele.Jeu;
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
			String url = "C:\\titzwatch" + File.separator + selectedValue.replaceAll(" ", "_")+".titz";
			
			MainController.getInstance().launchGame(chargerJeu(url));// TODO Revoir nom de launchGame (ne lance pas le jeu -> comportement ok : on le jeu est identifié à ce moment)
			CenterPanel.getInstance().changerEcranToGame();//Charge l'écran de jeu
			MainPanel.getInstance().repaint();//TODO Note: Le jeu peut être lancer après ça
			//GamePanel.getInstance().jouerBasicJeu();
			GamePanel.getInstance().jouerJeu();
		}
		
	}
	
	private Jeu chargerJeu(String url) {
		Jeu j = null;
		try {
			
			File f = new File(url);
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			j = (Jeu) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return j;
		
	}

	public void rightControlPress() {
		if(MainController.getInstance().isGameOn()) {
			System.out.println("right down");
			GamePanel.getInstance().getContextJeu().getEtatsTouches().put(Touche.DROITE, true);
		}
	}

	public void rightControlRelease() {
		if(MainController.getInstance().isGameOn()) {
			System.out.println("right up");
			GamePanel.getInstance().getContextJeu().getEtatsTouches().put(Touche.DROITE, false);
		}
	}
	
	public void leftControlPress() {
		if(MainController.getInstance().isGameOn()) {
			System.out.println("left down");
			GamePanel.getInstance().getContextJeu().getEtatsTouches().put(Touche.GAUCHE, true);
		}
	}

	public void leftControlRelease() {
		if(MainController.getInstance().isGameOn()) {
			System.out.println("left up");
			GamePanel.getInstance().getContextJeu().getEtatsTouches().put(Touche.GAUCHE, false);
		}
	}

	public void upControlPress() {
		if(MainController.getInstance().isGameOn()) {
			System.out.println("up down");
			GamePanel.getInstance().getContextJeu().getEtatsTouches().put(Touche.HAUT, true);
		}
	}

	public void upControlRelease() {
		if(MainController.getInstance().isGameOn()) {
			System.out.println("up up");
			GamePanel.getInstance().getContextJeu().getEtatsTouches().put(Touche.HAUT, false);
		}
	}
	
	public void downControlPress() {
		if(MainController.getInstance().isGameOn()) {
			System.out.println("down");
			GamePanel.getInstance().getContextJeu().getEtatsTouches().put(Touche.BAS, true);
		}
	}

	public void downControlRelease() {
		if(MainController.getInstance().isGameOn()) {
			System.out.println("down");
			GamePanel.getInstance().getContextJeu().getEtatsTouches().put(Touche.BAS, false);
		}
	}
}