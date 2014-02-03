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

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import fr.titouz.gamewatch.modeleur.modele.Jeu;


public class DecoupeurFond extends JPanel {
	
	private static final long serialVersionUID = 6913807389734526730L;
	private PanelImage panel;
	private Point click;
	
	public DecoupeurFond() {
		this.setLayout(new BorderLayout());
		
		this.panel = new PanelImage(-1);
		this.panel.setAfficherEcran(true);
		
		this.panel.ajouterListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				click = e.getPoint();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				panel.setDecalages(click, e.getPoint());
				panel.resetAncienPtDrag();
				sauvegarderImage();
			}
		});
		
		this.panel.ajouterListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseDragged(MouseEvent e) {
				panel.setDecalages(click, e.getPoint());
			}
		});

		this.add(this.panel, BorderLayout.CENTER);
	}
	
	public void updateImage() {
		this.panel.setImage(Jeu.getInstance().getFond());
	}
	
	public void sauvegarderImage() {
		Jeu.getInstance().setFond(this.panel.getImage());
	}
}
