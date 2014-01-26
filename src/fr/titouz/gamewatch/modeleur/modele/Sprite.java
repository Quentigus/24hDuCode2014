package fr.titouz.gamewatch.modeleur.modele;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Sprite implements Serializable {

	private static final long serialVersionUID = 8449098848147438233L;
	private Point coordonnees;
	private BufferedImage image;
	
	public Sprite(Point coordonnees, BufferedImage image) {
		this.coordonnees = coordonnees;
		this.image = image;
	}

	public Point getCoordonnees() {
		return coordonnees;
	}

	public BufferedImage getImage() {
		return image;
	}
}
