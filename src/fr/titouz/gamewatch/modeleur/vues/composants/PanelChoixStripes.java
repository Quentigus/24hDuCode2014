package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import fr.titouz.gamewatch.modeleur.modele.Jeu;
import java.util.Enumeration;
import javax.swing.AbstractButton;

public class PanelChoixStripes extends JPanel {

	private static final long serialVersionUID = 539606832283440253L;
	private ButtonGroup groupe;
	
	public PanelChoixStripes() {
		this.setPreferredSize(new Dimension(300, 20));
		
		this.groupe = new ButtonGroup();
		for (BufferedImage im : Jeu.getInstance().getLesSpritesDecoupes()) {
			BoutonSprite bouton = new BoutonSprite(im);
			this.groupe.add(bouton);
			this.add(bouton);
		}
	}
	public BufferedImage getSelectedSprite(){
		Enumeration<AbstractButton> elem = groupe.getElements();
		while(elem.hasMoreElements()){
			BoutonSprite spr = (BoutonSprite)(elem.nextElement());
			if(spr.isSelected()){
				return spr.getSelectedSprite();
			}
		}
		return null;
	}
}
