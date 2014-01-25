package fr.titouz.gamewatch.modeleur.vues.composants.fond;

import java.awt.BorderLayout;

import javax.swing.JPanel;


public class DecoupeurFond extends JPanel {
	
	private static final long serialVersionUID = 6913807389734526730L;
	
	public DecoupeurFond() {
		this.setLayout(new BorderLayout());
		
		this.add(new PanelFondDroite(), BorderLayout.EAST);
	}
}
