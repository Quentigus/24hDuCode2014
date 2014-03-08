
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

package fr.titouz.gamewatch.emulateur.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.titouz.gamewatch.emulateur.controller.MainController;
import fr.titouz.gamewatch.emulateur.view.common.CenterPanel;
import fr.titouz.gamewatch.emulateur.view.common.LeftBarPanel;
import fr.titouz.gamewatch.emulateur.view.common.RightBarPanel;
import fr.titouz.gamewatch.emulateur.view.game.GamePanel;
import fr.titouz.gamewatch.tools.ImagesHelper;

public class MainPanel extends JPanel{

	private static MainPanel instance;
	private Image img;
	private String url_fond_off = "ressources/fond.png";
	private String url_fond_on = "ressources/fondJeu.png";

	private MainPanel() {
		
	}

	public static synchronized MainPanel getInstance() {
		if (null == instance) {
			instance = new MainPanel();
		}
		return instance;
	}
	
	public MainPanel init() {
		//this.setMinimumSize(new Dimension(800,500));
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		this.setLayout(new BorderLayout(5, 5));
		this.add(LeftBarPanel.getInstance().init(), BorderLayout.WEST);
		this.add(CenterPanel.getInstance().init(),BorderLayout.CENTER);
		this.add(RightBarPanel.getInstance().init(),BorderLayout.EAST);
		
		return this;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		try {
			this.img = ImagesHelper.getImage(this.url_fond_off);
			
			if(this.img != null) {
				g.drawImage(this.img,0,0,this);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
