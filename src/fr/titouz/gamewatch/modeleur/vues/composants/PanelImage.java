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

import fr.titouz.gamewatch.modeleur.modele.Jeu;
import fr.titouz.gamewatch.modeleur.modele.Sprite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JPanel;

public class PanelImage extends JPanel {

	private static final long serialVersionUID = 3530809267375791882L;

	protected BufferedImage image;

	private boolean afficherTailleEcran = false;

	private int decalageHorizontal = 0;

	private int decalageVertical = 0;

	private Point ancienPtDrag = null;

	private int typeSprite;

	public PanelImage(int typeSprite) {
		this.typeSprite = typeSprite;
	}

	public PanelImage(BufferedImage pImage) {
		this.image = pImage;
		this.setPreferredSize(new Dimension(this.image.getWidth(), this.image.getHeight()));
	}

	public void ajouterListener(MouseListener pListener) {
		this.addMouseListener(pListener);
	}

	public void ajouterListener(MouseMotionAdapter pListener) {
		this.addMouseMotionListener(pListener);
	}

	public void setImage(BufferedImage img) {
		this.image = img;
		this.setPreferredSize(new Dimension(this.image.getWidth(), this.image.getHeight()));

		this.repaint();
		this.validate();
	}

	public void setDecalages(Point ptClick, Point ptDrag) {
		// D�calage du drag
		int decX;
		int decY;
		if (ancienPtDrag == null) {
			decX = (int) (ptDrag.getX() - ptClick.getX());
			decY = (int) (ptDrag.getY() - ptClick.getY());
		}
		else {
			decX = (int) ((ptDrag.getX() - ancienPtDrag.getX()));
			decY = (int) ((ptDrag.getY() - ancienPtDrag.getY()));
		}

		int decalagePossibleX = this.decalageHorizontal - decX;
		int decalagePossibleY = this.decalageVertical - decY;

		if (decalagePossibleX >= 0 && decalagePossibleX < this.image.getWidth() - 600) {
			this.decalageHorizontal = decalagePossibleX;
			ancienPtDrag = ptDrag;
		}
		if (decalagePossibleY >= 0 && decalagePossibleY < this.image.getHeight() - 350) {
			this.decalageVertical = decalagePossibleY;
			ancienPtDrag = ptDrag;
		}

		this.repaint();
		this.validate();
	}

	public void resetAncienPtDrag() {
		ancienPtDrag = null;
	}

	public void setAfficherEcran(boolean afficher) {
		this.afficherTailleEcran = afficher;
		this.setPreferredSize(new Dimension(601, 351));
		this.setMaximumSize(new Dimension(601, 351));
	}

	public BufferedImage getImage() {
		if (this.afficherTailleEcran) {
			return this.image.getSubimage(this.decalageHorizontal, this.decalageVertical, 600, 350);
		}
		else {
			return this.image;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			if (this.afficherTailleEcran) {
				g.drawImage(image.getSubimage(this.decalageHorizontal, this.decalageVertical, 600, 350), 0, 0, null);
				g.drawRect(0, 0, 600, 350);
			}
			else {
				g.drawImage(image, 0, 0, null);
				
				for (Sprite s : Jeu.getInstance().getLesFixes()) {
					((Graphics2D) g).drawImage(s.getImage(), null, (int) s.getCoordonnees().getX(), (int) s.getCoordonnees().getY());
				}
				for (Sprite s : Jeu.getInstance().getLesPersonnages()) {
					((Graphics2D) g).drawImage(s.getImage(), null, (int) s.getCoordonnees().getX(), (int) s.getCoordonnees().getY());
				}
				for (Sprite s : Jeu.getInstance().getLesEnnemies()) {
					((Graphics2D) g).drawImage(s.getImage(), null, (int) s.getCoordonnees().getX(), (int) s.getCoordonnees().getY());
				}
			}
		}
	}
}