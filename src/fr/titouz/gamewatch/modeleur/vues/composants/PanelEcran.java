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

import javax.swing.JPanel;

import fr.titouz.gamewatch.modeleur.modele.Jeu;

public class PanelEcran extends JPanel {

	private static final long serialVersionUID = 7006609470013501649L;
	private PanelImage ecran;		
	
	public PanelEcran(int typeSprite) {
		this.ecran = new PanelImage(typeSprite);
		this.ecran.setImage(Jeu.getInstance().getFond());
		this.ecran.setPreferredSize(new Dimension(600, 350));
		
		this.add(ecran);
	}

	public PanelImage getEcran() {
		return ecran;
	}
}
