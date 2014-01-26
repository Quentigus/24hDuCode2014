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

package fr.titouz.gamewatch.emulateur.view.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.swing.JPanel;

import test.TestJeu.TabAffListener;

import fr.titouz.gamewatch.emulateur.controller.MainController;
import fr.titouz.gamewatch.jeu.Etat;
import fr.titouz.gamewatch.jeu.Sequence;
import fr.titouz.gamewatch.jeu.TourDeJeuListener;
import fr.titouz.gamewatch.jeu.Transition;
import fr.titouz.gamewatch.jeu.transitions.TransitionAleatoire;
import fr.titouz.gamewatch.jeu.transitions.TransitionSimple;
import fr.titouz.gamewatch.modeleur.modele.Jeu;
import fr.titouz.gamewatch.modeleur.modele.Sprite;
import fr.titouz.gamewatch.tools.ImagesHelper;

public class GamePanel extends JPanel{

	private static GamePanel instance;
	private final String url_home = "ressources/screen_home.png";
	private final String url_over = "ressources/game_over.png";
	private fr.titouz.gamewatch.jeu.Jeu jeu;

	private GamePanel() {
	}

	public static synchronized GamePanel getInstance() {
		if (null == instance) {
			instance = new GamePanel();
		}
		return instance;
	}
	
	public GamePanel init() {
		this.setMinimumSize(new Dimension(600,350));
		this.setPreferredSize(new Dimension(600,350));
		this.setMaximumSize(new Dimension(600,350));
		
		if(!MainController.getInstance().isGameOn()) {
			this.setBackground(Color.black);
		}
		
		
		
		
		return this;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		if(MainController.getInstance().isGameOn()) {
			Jeu j = MainController.getInstance().getJeu();
			if(j.getFond() != null) {
				g.drawImage(j.getFond(),0,0,this);
			}
			for(Sprite s: j.getLesPersonnages()) {
				if(s.isVisible()) {
					g.drawImage(s.getImage(), s.getCoordonnees().x, s.getCoordonnees().y, this);
				}
			}
			for(Sprite s: j.getLesEnnemies()) {
				if(s.isVisible()) {
					g.drawImage(s.getImage(), s.getCoordonnees().x, s.getCoordonnees().y, this);
				}
			}
			for(Sprite s: j.getLesFixes()) {
				if(s.isVisible()) {
					g.drawImage(s.getImage(), s.getCoordonnees().x, s.getCoordonnees().y, this);
				}
			}
		}
	}
	
	public void jouerBasicJeu() {
		jeu = new fr.titouz.gamewatch.jeu.Jeu();
		Jeu j = MainController.getInstance().getJeu();
		List<Sprite> list = j.getLesPersonnages();
		if(list.size() >= 4) {
			Etat e1 = new Etat();
			e1.setActif(true);
			Etat e2 = new Etat();
			Etat e3 = new Etat();
			Etat e4 = new Etat();
	
			Sequence s1 = new Sequence(e1);
			jeu.getSequences().add(s1);
			
			Transition t12 = new TransitionSimple(jeu.getContext(), s1, e1);
			t12.getEtatSortie().add(e2);
			Transition t234 = new TransitionAleatoire(jeu.getContext(), s1, e2);
			t234.getEtatSortie().add(e3);
			t234.getEtatSortie().add(e4);
			Transition t31 = new TransitionSimple(jeu.getContext(), s1, e3);
			t31.getEtatSortie().add(e1);
			Transition t41 = new TransitionSimple(jeu.getContext(), s1, e4);
			t41.getEtatSortie().add(e1);
			
			TabAffListener listener = new TabAffListener();
			listener.e[0] = e1;
			listener.e[1] = e2;
			listener.e[2] = e3;
			listener.e[3] = e4;
			
			for(int i = 0; i < 4; i++) {
				list.get(i).setEtat(listener.e[i]);
			}

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
	}
	
	public static class TabAffListener implements TourDeJeuListener {
		public Etat[] e;
		
		public TabAffListener() {
			e = new Etat[4];
		}
		@Override
		public void notifier() {
			GamePanel.getInstance().repaint();
			GamePanel.getInstance().validate();
		}
	}
}
