package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ChargerFond extends JPanel {

	private static final long serialVersionUID = -4341635109223065955L;
	private PanelParcourir parcourir;
	
	public ChargerFond(ActionListener pListener) {
		this.parcourir = new PanelParcourir(pListener);
		this.add(this.parcourir, BorderLayout.CENTER);
	}
}
