package fr.titouz.gamewatch.tools;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Permet de gérer les images.
 *
 * @since 1.0
 * @version 1.0
 */
public final class ImagesHelper {

	/**
	 * Permet de récupérer une image.
	 *
	 * @since 1.0
	 *
	 * @param name nom du fichier
	 * @return l'image
	 */
	public static Image getImage(String name) throws IOException, MalformedURLException {
		URL url = new File("ressources" + File.separator + "images" + File.separator + name).toURI().toURL();

		if (url != null) {
			return ImageIO.read(url);

		}
		return null;
	}

	/**
	 * Permet de récupérer une icône.
	 *
	 * @since 1.0
	 *
	 * @param name nom du fichier
	 * @return l'icône
	 */
	public static Icon getIcon(String name) throws MalformedURLException {
		URL url = new File("ressources" + File.separator + "images" + File.separator + name).toURI().toURL();
		if (url != null) {
			return new ImageIcon(url);
		}
		return null;
	}

	/**
	 * Permet de redimensionner la taille d'une image
	 *
	 * @param l'image à redimensionner
	 * @param largeur
	 * @param longueur
	 *
	 * @return l'image redimensionné
	 */
	public static Image resizeImg(Image img, int width, int height) {
		return img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
	}
}