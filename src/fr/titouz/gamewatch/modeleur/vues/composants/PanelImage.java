package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelImage extends JPanel {

	private static final long serialVersionUID = 3530809267375791882L;
	protected BufferedImage image;
	private boolean afficherTailleEcran = false;
	private int decalageHorizontal = 0;
	private int decalageVertical = 0;
	private Point ancienPtDrag = null;

	public PanelImage() { }

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

	public void setImage(String url) {
		try {
			this.image = ImageIO.read(new URL("file:\\" + url));
			this.setPreferredSize(new Dimension(this.image.getWidth(), this.image.getHeight()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setDecalages(Point ptClick, Point ptDrag) {
		// Décalage du drag
		int decX ;
		int decY ;
		if(ancienPtDrag == null){
			decX = (int)(ptDrag.getX() - ptClick.getX());
			decY = (int)(ptDrag.getY() - ptClick.getY());
		}else{
			decX = (int)((ptDrag.getX() - ancienPtDrag.getX()));
			decY = (int)((ptDrag.getY() - ancienPtDrag.getY()));
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
	
	public void resetAncienPtDrag(){
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
			}
		}
	}

}