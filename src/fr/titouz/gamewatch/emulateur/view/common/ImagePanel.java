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

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.titouz.gamewatch.tools.ImagesHelper;

public class ImagePanel extends JPanel{

	private String url;
	private Image img;
	
	public ImagePanel (String url) {
		this.url = url;
		this.setPreferredSize(new Dimension(100,100));
	}
	
	public void paint(Graphics g) {
		super.paintComponents(g);
		try {
			this.img = ImagesHelper.getImage(this.url);
			if(this.img != null) {
				g.drawImage(this.img,0,0,this);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
