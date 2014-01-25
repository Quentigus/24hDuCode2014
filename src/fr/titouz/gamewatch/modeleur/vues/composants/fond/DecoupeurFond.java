package fr.titouz.gamewatch.modeleur.vues.composants.fond;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import fr.titouz.gamewatch.modeleur.vues.composants.PanelImage;


public class DecoupeurFond extends JPanel {
	
	private static final long serialVersionUID = 6913807389734526730L;
	private PanelImage panel;
	
	public DecoupeurFond() {
		this.setLayout(new BorderLayout());
		
		this.panel = new PanelImage();
		this.add(panel);
		
		this.add(new PanelFondDroite(), BorderLayout.EAST);
	}
}
