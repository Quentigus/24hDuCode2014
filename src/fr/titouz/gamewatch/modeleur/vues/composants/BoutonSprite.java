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

package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import fr.titouz.gamewatch.tools.ImagesHelper;

public class BoutonSprite extends JToggleButton {

	private static final long serialVersionUID = 6737419205564959202L;
	
	private BufferedImage selectedSprite;

	public BoutonSprite(BufferedImage pImage) {
		this.selectedSprite = pImage;
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setIcon(new ImageIcon(ImagesHelper.resizeImg(selectedSprite, 35, 35)));
		this.setPreferredSize(new Dimension(90, 70));
		this.setText(selectedSprite.getWidth() + "x" + selectedSprite.getHeight());
	}

	public BufferedImage getSelectedSprite() {
		return selectedSprite;
	}
}
