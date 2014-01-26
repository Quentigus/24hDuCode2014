package fr.titouz.gamewatch.modeleur.vues.composants.fond;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import fr.titouz.gamewatch.modeleur.vues.composants.PanelParcourir;

public class ChargerFond extends JPanel {

	private static final long serialVersionUID = -4341635109223065955L;
	private PanelParcourir parcourir;
	
	public ChargerFond() {
		this.parcourir = new PanelParcourir(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// Parcourir
						JFileChooser chooser = new JFileChooser();
						FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
						chooser.setFileFilter(filter);
						int returnVal = chooser.showOpenDialog(null);
						if (returnVal == JFileChooser.APPROVE_OPTION) {
							System.out.println(chooser.getSelectedFile().getPath());
						}
					}
				}
			);
		
		this.parcourir.setPreferredSize(new Dimension(300, 20));
		this.add(this.parcourir, BorderLayout.CENTER);
	}
}
