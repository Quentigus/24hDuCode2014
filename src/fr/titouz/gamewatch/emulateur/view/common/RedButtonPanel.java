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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class RedButtonPanel extends JPanel{

	private static RedButtonPanel instance;
	private int x,y,diameter;

	private RedButtonPanel() {
		x = this.getWidth()/2;
		y = this.getHeight()/2;
		diameter = this.getWidth();
	}

	public static synchronized RedButtonPanel getInstance() {
		if (null == instance) {
			instance = new RedButtonPanel();
		}
		return instance;
	}
	
	public RedButtonPanel init() {
		this.setOpaque(false);
		this.setLayout(null);
		
		return this;
	}
	
	public void painComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D)g;
		Ellipse2D.Double circle = new Ellipse2D.Double(x,y,diameter,diameter);
		g2d.setBackground(Color.red);
		g2d.fill(circle);
	}
}


