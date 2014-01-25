package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

public class PanelEcran extends JPanel {

	private static final long serialVersionUID = 7006609470013501649L;
	private JPanel ecran;
	
	public PanelEcran(MouseAdapter pListener) {
		this.ecran = new JPanel();
		this.ecran.setPreferredSize(new Dimension(500, 350));
		this.ecran.setBackground(Color.red);
		
		this.add(ecran);
	}
}
