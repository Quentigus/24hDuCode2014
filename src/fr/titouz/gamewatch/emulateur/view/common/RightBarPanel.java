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

package fr.titouz.gamewatch.emulateur.view.common;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

import fr.titouz.gamewatch.emulateur.controller.ControlController;
import fr.titouz.gamewatch.emulateur.controller.MainController;


public class RightBarPanel extends JPanel{
	
	private static RightBarPanel instance;

	private RightBarPanel() {
	}

	public static synchronized RightBarPanel getInstance() {
		if (null == instance) {
			instance = new RightBarPanel();
		}
		return instance;
	}
	
	public RightBarPanel init() {
		try {
			this.setOpaque(false);
			this.setPreferredSize(new Dimension(100,500));
			this.setLayout(new BorderLayout());

			ImagePanel imPan = new ImagePanel("ressources/flecheDroite.png");
			this.add(imPan, BorderLayout.SOUTH);
			imPan.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					if(MainController.getInstance().isGameOn()) {
						System.out.println("clic droit");
						ControlController.getInstance().rightControlPress();
					}
				}
				
				@Override
				public void mouseReleased(MouseEvent e) {
					if(MainController.getInstance().isGameOn()) {
						System.out.println("clic droit");
						ControlController.getInstance().rightControlRelease();
					}
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return this;
	}

}
