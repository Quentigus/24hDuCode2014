package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

public class PanelEcran extends JPanel {

	private static final long serialVersionUID = 7006609470013501649L;
	private PanelImage ecran;
	
	public PanelEcran(MouseAdapter pListener) {
		this.ecran = new PanelImage();
		//this.ecran.setImage(Jeu.getInstance().getFond());
		this.ecran.setPreferredSize(new Dimension(600, 350));
		
		this.add(ecran);
	}
}
