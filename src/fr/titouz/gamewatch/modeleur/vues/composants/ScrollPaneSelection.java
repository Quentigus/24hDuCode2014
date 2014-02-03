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

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.titouz.gamewatch.modeleur.modele.Jeu;

/**
 *
 * @author Bastien Andru <bastien.andru@gmail.com>
 */
public class ScrollPaneSelection extends JScrollPane {

	private JPanel panelSprites;

	private PanelImagePeignable pan;

	/**
	 * Default constructor of
	 * <code>ScrollPaneSelection</code>.
	 */
	public ScrollPaneSelection(PanelImagePeignable pan, JPanel panelSprites) {
		super(pan);

		this.pan = pan;
		this.panelSprites = panelSprites;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cliqueSouris(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				relacheSouris(e);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
    cursorImg, new Point(0, 0), "blank cursor"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				setCursor(Cursor.getDefaultCursor());
			}
			
			
			
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				super.mouseDragged(e);
				dragSouris(e);
			}
			

			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
				dragSouris(e);
			}
		});


	}

	private void cliqueSouris(MouseEvent e) {
		pan.setPtClick(e.getPoint());
		pan.setPtDrag(e.getPoint());

		this.repaint();

	}

	private void relacheSouris(MouseEvent e) {
		BufferedImage sub = pan.getSubImage();
		if(sub != null){
			// Ajout de l'image dans le modele
			Jeu.getInstance().ajouterSpriteDecoupe(sub);
			
			// Gestion du graphique
			this.repaint();
			this.panelSprites.add(new BoutonSprite(sub));
			this.panelSprites.revalidate();
			this.panelSprites.repaint();
		}
	}

	private void dragSouris(MouseEvent e) {
		pan.setPtDrag(e.getPoint());
		this.repaint();
	}

	public PanelImagePeignable getPan() {
		return pan;
	}
}