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

package fr.titouz.gamewatch.emulateur.view.game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

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
		this.setBackground(Color.black);
		
		
		return this;
	}
}
