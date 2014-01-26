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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import fr.titouz.gamewatch.emulateur.view.MainPanel;
import fr.titouz.gamewatch.emulateur.view.common.CenterPanel;
import fr.titouz.gamewatch.emulateur.view.game.GamePanel;
import fr.titouz.gamewatch.emulateur.view.game.GameTitlePanel;
import fr.titouz.gamewatch.jeu.Etat;
import fr.titouz.gamewatch.jeu.Sequence;
import fr.titouz.gamewatch.jeu.TourDeJeuListener;
import fr.titouz.gamewatch.jeu.Transition;
import fr.titouz.gamewatch.jeu.transitions.TransitionToucheGauche;
import fr.titouz.gamewatch.modeleur.modele.GTransition;
import fr.titouz.gamewatch.modeleur.modele.Jeu;
import fr.titouz.gamewatch.tools.Repertoire;

public class ControlController {

	private static ControlController instance;
	private fr.titouz.gamewatch.jeu.Jeu jeu;

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
			String url = "C:\\titzwatch\\"+selectedValue.replaceAll(" ", "_")+".titz";
			
			MainController.getInstance().launchGame(chargerJeu(url));
			CenterPanel.getInstance().changerEcranToGame();
			MainPanel.getInstance().repaint();
			chargeEtLanceModelJeu();
			//GamePanel.getInstance().jouerBasicJeu();
		}
		
	}
	
	private void chargeEtLanceModelJeu() {
		Jeu j = MainController.getInstance().getJeu();
		jeu = new fr.titouz.gamewatch.jeu.Jeu();
		for(GTransition gt : j.getLesSequences()) {	
			Etat init = new Etat();
			init.setActif(true);
			Etat fin = new Etat();
			Sequence s = new Sequence(init);
			jeu.getSequences().add(s);
			
			gt.getInitial().setEtat(init);
			gt.getDestination().setEtat(fin);
			if(gt.getCondition().equals("gauche")) {
				Transition t = new TransitionToucheGauche(jeu.getContext(), s, init);
				t.getEtatSortie().add(fin);
			}
		}
		
		TourDeJeuListener listener = new TourDeJeuListener() {
			@Override
			public void notifier() {
				GamePanel.getInstance().repaint();
				GamePanel.getInstance().validate();
			}
		};
		
		
		jeu.addTourDeJeuListener(listener);
		listener.notifier();
		jeu.jouer();
		Thread thrd = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					System.err.println("Thread attente testJouer interrompu.");
				}
				jeu.stop();
				
			}
			
		});
		thrd.start();
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
