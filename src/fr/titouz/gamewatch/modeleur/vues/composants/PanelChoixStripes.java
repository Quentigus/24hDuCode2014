package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class PanelChoixStripes extends JPanel {

	private static final long serialVersionUID = 539606832283440253L;
	private ButtonGroup groupe;
	
	public PanelChoixStripes() {
		this.setPreferredSize(new Dimension(300, 20));
		
		ArrayList<BufferedImage> lesImages = new ArrayList<>();
		try {
			lesImages.add(ImageIO.read(new URL("file:\\C:\\Users\\quent_000\\Desktop\\1.png")));
			lesImages.add(ImageIO.read(new URL("file:\\C:\\Users\\quent_000\\Desktop\\2.png")));
			lesImages.add(ImageIO.read(new URL("file:\\C:\\Users\\quent_000\\Desktop\\2.png")));
			lesImages.add(ImageIO.read(new URL("file:\\C:\\Users\\quent_000\\Desktop\\2.png")));
			lesImages.add(ImageIO.read(new URL("file:\\C:\\Users\\quent_000\\Desktop\\2.png")));
			lesImages.add(ImageIO.read(new URL("file:\\C:\\Users\\quent_000\\Desktop\\2.png")));
			lesImages.add(ImageIO.read(new URL("file:\\C:\\Users\\quent_000\\Desktop\\2.png")));
			lesImages.add(ImageIO.read(new URL("file:\\C:\\Users\\quent_000\\Desktop\\2.png")));
			lesImages.add(ImageIO.read(new URL("file:\\C:\\Users\\quent_000\\Desktop\\1.png")));
			lesImages.add(ImageIO.read(new URL("file:\\C:\\Users\\quent_000\\Desktop\\3.png")));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.groupe = new ButtonGroup();
		for (BufferedImage im : lesImages) {
			BoutonSprite bouton = new BoutonSprite(im);
			
			bouton.setText(im.getWidth() + "x" + im.getHeight());
			this.groupe.add(bouton);
			
			this.add(bouton);
		}
	}
}
