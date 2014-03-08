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

import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * This class holds a {@link BufferedImage}, when the {@link BufferedImage} is
 * Serialized it is saved as a multi-dimensional Array of ARBG pixel integers.
 * <p>
 * The <code>get()</code> method returns the {@link BufferedImage}, if it has
 * been Serialized, it re-creates the {@link BufferedImage} from the pixel data
 * Array and then returns it.
 * 
 * @author Sebastian Troy
 * 
 */
public class ImageSerialisable2 implements Serializable
{
	private static final long serialVersionUID = 1L;

	private transient BufferedImage image = null;

	private int imageWidth;
	private int imageHeight;
	private int[][] pixelArray;

	/**
	 * @param image
	 *            - the {@link BufferedImage} which needs to be
	 *            {@link Serializable}
	 */
	public ImageSerialisable2(BufferedImage image)
	{
		set(image);
	}

	/**
	 * @param image
	 *            - the {@link BufferedImage} you wish this class to
	 *            represent.
	 */
	public void set(BufferedImage image)
	{
		this.image = image;

		imageWidth = image.getWidth();
		imageHeight = image.getHeight();

		pixelArray = new int[imageWidth][imageHeight];

		setPixelArray();
	}

	/**
	 * If the {@link BufferedImage} is null, it re-loads the image from the
	 * stored pixel data in <code>pixelArray</code>.
	 * <p>
	 * It always returns the {@link BufferedImage} stored in this class.
	 * 
	 * @return the {@link BufferedImage} stored in the instance of this
	 *         class.
	 */
	public BufferedImage get()
	{
		if (image == null)
		{
			image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
			for (int x = 0; x < imageWidth; x++)
				for (int y = 0; y < imageHeight; y++)
					image.setRGB(x, y, pixelArray[x][y]);
		}
		return image;
	}

	private void setPixelArray()
	{
		for (int x = 0; x < imageWidth; x++)
			for (int y = 0; y < imageHeight; y++)
				pixelArray[x][y] = image.getRGB(x, y);
	}

}