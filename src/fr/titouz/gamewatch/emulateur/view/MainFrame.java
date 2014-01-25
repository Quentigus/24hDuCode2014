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

package fr.titouz.gamewatch.emulateur.view;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import fr.titouz.gamewatch.emulateur.controller.ControlController;

public class MainFrame extends JFrame{

	private static MainFrame instance;

	private MainFrame() {
	}

	public static synchronized MainFrame getInstance() {
		if (null == instance) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	public MainFrame init() {
		this.setMinimumSize(new Dimension(820, 520));
		this.setContentPane(MainPanel.getInstance().init());
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		
		//event
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyChar());
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					ControlController.getInstance().rightControl();
					break;
				case KeyEvent.VK_UP:
					ControlController.getInstance().upControl();
					break;
				case KeyEvent.VK_LEFT:
					ControlController.getInstance().leftControl();
					break;
				case KeyEvent.VK_DOWN:
					ControlController.getInstance().downControl();
					break;

				default:
					break;
				}
			}
		});
		
		return this;
	}
}
