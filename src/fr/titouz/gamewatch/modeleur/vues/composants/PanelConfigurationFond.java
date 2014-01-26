package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
		
		this.add(new ChargerFond(
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
								decoupeur.updateImage();
							} catch (IOException ex) {
								ex.printStackTrace();
							}
						}
					}
				}
			), BorderLayout.NORTH);
		this.add(this.decoupeur, BorderLayout.CENTER);
	}
}
