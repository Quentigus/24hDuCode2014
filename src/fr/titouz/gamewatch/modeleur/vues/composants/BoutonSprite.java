package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import fr.titouz.gamewatch.tools.ImagesHelper;

public class BoutonSprite extends JToggleButton {

	private static final long serialVersionUID = 6737419205564959202L;

	public BoutonSprite(BufferedImage pImage) {
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setIcon(new ImageIcon(ImagesHelper.resizeImg(pImage, 35, 35)));
		this.setPreferredSize(new Dimension(90, 70));
	}
}
