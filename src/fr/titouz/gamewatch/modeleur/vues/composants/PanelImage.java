package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelImage extends JPanel {

	private static final long serialVersionUID = 3530809267375791882L;
	private BufferedImage image;

	public PanelImage() { }
	
	public PanelImage(BufferedImage pImage) {
		this.image = pImage;
		this.setPreferredSize(new Dimension(this.image.getWidth(), this.image.getHeight()));
	}
	
	public void setImage(String url) {
		try {
			this.image = ImageIO.read(new URL("file:\\C:\\Users\\quent_000\\Desktop\\1.png"));
			this.setPreferredSize(new Dimension(this.image.getWidth(), this.image.getHeight()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, null);            
		}
	}

}