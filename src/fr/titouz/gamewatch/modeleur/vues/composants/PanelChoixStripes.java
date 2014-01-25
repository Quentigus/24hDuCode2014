package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelChoixStripes extends JPanel {

	private static final long serialVersionUID = 539606832283440253L;

	public PanelChoixStripes() {
		this.setPreferredSize(new Dimension(300, 20));
		this.setLayout(new BorderLayout());

		ArrayList<BufferedImage> lesImages = new ArrayList<>();
		try {
			lesImages.add(ImageIO.read()));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (BufferedImage im : lesImages) {
			this.add(new PanelImage(im));
		}
	}
}
