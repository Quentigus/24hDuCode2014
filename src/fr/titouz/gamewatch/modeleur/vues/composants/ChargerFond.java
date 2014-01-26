package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import fr.titouz.gamewatch.modeleur.modele.Jeu;

public class ChargerFond extends JPanel {

	private static final long serialVersionUID = -4341635109223065955L;
	private PanelParcourir parcourir;
	
	public ChargerFond() {
		final ChargerFond self = this;
		
		this.parcourir = new PanelParcourir(
				new ActionListener() {
					
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
							} catch (IOException ex) {
								ex.printStackTrace();
							}
						}
					}
				}
			);
		
		this.add(this.parcourir, BorderLayout.CENTER);
	}
}
