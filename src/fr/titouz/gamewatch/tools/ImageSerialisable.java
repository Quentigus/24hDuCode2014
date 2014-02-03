/* Copyright ANDRU Bastien, CARRE, Gaël DUROY Adrien, GOSSELIN Quentin, JARROT Kathleen
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

package fr.titouz.gamewatch.tools;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class ImageSerialisable implements Serializable {

	private static final long serialVersionUID = -8265207274323249542L;

	int width; int height; int[] pixels;

	public ImageSerialisable(BufferedImage bi) { 
		width = bi.getWidth(); 
		height = bi.getHeight(); 
		pixels = new int[width * height]; 
		int[] tmp=bi.getRGB(0,0,width,height,pixels,0,width); 
	}

	public BufferedImage getImage() { 
		BufferedImage bi = new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
		bi.setRGB(0,0,width,height,pixels,0,width);
		return bi; 
	} 

}