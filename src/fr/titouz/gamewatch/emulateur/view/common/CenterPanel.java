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

package fr.titouz.gamewatch.emulateur.view.common;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.titouz.gamewatch.emulateur.view.control.ControlPanel;
import fr.titouz.gamewatch.emulateur.view.game.GamePanel;
import fr.titouz.gamewatch.emulateur.view.game.GameTitlePanel;

public class CenterPanel extends JPanel{

	private static CenterPanel instance;

	private CenterPanel() {
	}

	public static synchronized CenterPanel getInstance() {
		if (null == instance) {
			instance = new CenterPanel();
		}
		return instance;
	}
	
	public CenterPanel init() {
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(600,500));
		this.add(GameTitlePanel.getInstance().init().setHome(), BorderLayout.NORTH);
		this.add(ControlPanel.getInstance().init(), BorderLayout.SOUTH);
		
		return this;
	}

	public void changerEcranToGame() {
		if(((BorderLayout)this.getLayout()).getLayoutComponent(BorderLayout.NORTH) instanceof GameTitlePanel) {
			this.remove(((BorderLayout)this.getLayout()).getLayoutComponent(BorderLayout.NORTH));
			this.add(GamePanel.getInstance().init(),BorderLayout.NORTH);
			this.repaint();this.validate();
		}
		
	}
	
	public void changerEcranToGameOver() {
		if(((BorderLayout)this.getLayout()).getLayoutComponent(BorderLayout.NORTH) instanceof GamePanel) {
			this.remove(((BorderLayout)this.getLayout()).getLayoutComponent(BorderLayout.NORTH));
			this.add(GameTitlePanel.getInstance().init().setGameOver(),BorderLayout.NORTH);
			this.repaint();this.validate();
		}
		
	}
	
	public void changerEcranToHome() {
		if(((BorderLayout)this.getLayout()).getLayoutComponent(BorderLayout.NORTH) instanceof GamePanel) {
			this.remove(((BorderLayout)this.getLayout()).getLayoutComponent(BorderLayout.NORTH));
			this.add(GameTitlePanel.getInstance().init().setHome(),BorderLayout.NORTH);
			this.repaint();this.validate();
		}
		
	}
}
