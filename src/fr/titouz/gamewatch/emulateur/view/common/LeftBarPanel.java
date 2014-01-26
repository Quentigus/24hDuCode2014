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

public class LeftBarPanel extends JPanel{
	
	private static LeftBarPanel instance;

	private LeftBarPanel() {
	}

	public static synchronized LeftBarPanel getInstance() {
		if (null == instance) {
			instance = new LeftBarPanel();
		}
		return instance;
	}
	
	public LeftBarPanel init() {
		try {
			this.setOpaque(false);
			this.setPreferredSize(new Dimension(100,500));
			this.setLayout(new BorderLayout());
			this.add(new ImagePanel("ressources/flecheDroite.png"), BorderLayout.SOUTH);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this;
	}

}
