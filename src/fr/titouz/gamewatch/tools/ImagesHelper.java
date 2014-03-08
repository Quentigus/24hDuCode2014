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
		URL url = new File(name).toURI().toURL();

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
		URL url = new File(name).toURI().toURL();
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