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

package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Bastien Andru <bastien.andru@gmail.com>
 */
public class DecoupeurSprites extends JPanel {
	
	private static final long serialVersionUID = -8188541086512216388L;
	private JButton boutChoixIm;
	private ScrollPaneSelection jsp = null;
	private JPanel panelSprites;

	/**
	 * Default constructor of
	 * <code>DecoupeurSprites</code>.
	 */
	public DecoupeurSprites() {
		this.setLayout(new BorderLayout());
		
		this.boutChoixIm = new JButton("Parcourir ...");
		
		boutChoixIm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choisirImage();
			}
		});
		
		this.add(boutChoixIm, BorderLayout.NORTH);
		this.panelSprites = new JPanel(new FlowLayout());
		this.add(panelSprites, BorderLayout.WEST);
		panelSprites.setPreferredSize(new Dimension(300, 20));
		
	}
	
	private void choisirImage() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			chargImage(chooser.getSelectedFile().getPath());
		}
	}
	
	private void chargImage(String imgPath) {
		try {
			if (jsp == null) {
				jsp = new ScrollPaneSelection(new PanelImagePeignable(ImageIO.read(new File(imgPath))), panelSprites);
			}
			else {
				jsp.getPan().setImage(ImageIO.read(new File(imgPath)));
			}
			this.add(jsp, BorderLayout.CENTER);
			this.validate();
			this.repaint();
		} catch (IOException ex) {
			Logger.getLogger(DecoupeurSprites.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
