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
import java.io.IOException;

import javax.swing.JPanel;

import fr.titouz.gamewatch.emulateur.controller.MainController;
import fr.titouz.gamewatch.modeleur.modele.Jeu;
import fr.titouz.gamewatch.tools.ImagesHelper;

public class GamePanel extends JPanel{

	private static GamePanel instance;
	private final String url_home = "ressources/screen_home.png";
	private final String url_over = "ressources/game_over.png";

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
		
		if(MainController.getInstance().isGameOn()) {
			
		}
		else {
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
		}
	}
}
