package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.Dimension;

import javax.swing.JPanel;

import fr.titouz.gamewatch.modeleur.modele.Jeu;

public class PanelEcran extends JPanel {

	private static final long serialVersionUID = 7006609470013501649L;
	private PanelImage ecran;		
	
	public PanelEcran(int typeSprite) {
		this.ecran = new PanelImage(typeSprite);
		this.ecran.setImage(Jeu.getInstance().getFond());
		this.ecran.setPreferredSize(new Dimension(600, 350));
		
		this.add(ecran);
	}

	public PanelImage getEcran() {
		return ecran;
	}
}
