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

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import fr.titouz.gamewatch.modeleur.modele.Jeu;
import java.util.Enumeration;
import javax.swing.AbstractButton;

public class PanelChoixStripes extends JPanel {

	private static final long serialVersionUID = 539606832283440253L;
	private ButtonGroup groupe;
	
	public PanelChoixStripes() {
		this.setPreferredSize(new Dimension(300, 20));
		
		this.groupe = new ButtonGroup();
		for (BufferedImage im : Jeu.getInstance().getLesSpritesDecoupes()) {
			BoutonSprite bouton = new BoutonSprite(im);
			this.groupe.add(bouton);
			this.add(bouton);
		}
	}
	public BufferedImage getSelectedSprite(){
		Enumeration<AbstractButton> elem = groupe.getElements();
		while(elem.hasMoreElements()){
			BoutonSprite spr = (BoutonSprite)(elem.nextElement());
			if(spr.isSelected()){
				return spr.getSelectedSprite();
			}
		}
		return null;
	}
}
