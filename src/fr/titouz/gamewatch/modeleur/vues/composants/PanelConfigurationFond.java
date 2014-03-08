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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import fr.titouz.gamewatch.modeleur.modele.Jeu;

public class PanelConfigurationFond extends JPanel {

	private static final long serialVersionUID = -5529956988170333990L;
	private DecoupeurFond decoupeur;
	
	public PanelConfigurationFond() {
		this.setLayout(new BorderLayout());
		final JPanel self = this;
		
		this.decoupeur = new DecoupeurFond();
		
		JButton parcourir = new JButton("Parcourir ...");
		parcourir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Parcourir
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(self);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						Jeu.getInstance().setFond(ImageIO.read(new File(chooser.getSelectedFile().getPath())));
						decoupeur.updateImage();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		this.add(parcourir, BorderLayout.NORTH);
		this.add(this.decoupeur, BorderLayout.CENTER);
	}
}
