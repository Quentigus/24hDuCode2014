package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PanelImage extends JPanel {

	private static final long serialVersionUID = 3530809267375791882L;
	private BufferedImage image;

	public PanelImage(BufferedImage pImage) {
		this.image = pImage;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
	}

}