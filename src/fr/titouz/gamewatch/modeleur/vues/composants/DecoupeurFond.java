package fr.titouz.gamewatch.modeleur.vues.composants;

import javax.swing.JPanel;

import fr.titouz.gamewatch.modeleur.vues.composants.fond.listeners.DecalageHorizontalListener;
import fr.titouz.gamewatch.modeleur.vues.composants.fond.listeners.DecalageVerticalListener;
import fr.titouz.gamewatch.modeleur.vues.composants.fond.listeners.EchelleListener;
import fr.titouz.gamewatch.modeleur.vues.composants.fond.listeners.OpaciteListener;


public class DecoupeurFond extends JPanel {
	
	private static final long serialVersionUID = 6913807389734526730L;
	private PanelSlider decalageH;
	private PanelSlider decalageV;
	private PanelSlider echelle;
	private PanelSlider opacite;
	
	public DecoupeurFond() {
		this.decalageH = new PanelSlider("Décalage horizontal", new DecalageHorizontalListener());
		this.decalageV = new PanelSlider("Décalage vertical", new DecalageVerticalListener());
		this.echelle = new PanelSlider("Echelle", 0, 200, 100, new EchelleListener());
		this.opacite = new PanelSlider("Opacité", 0, 100, 20, new OpaciteListener());
	}
}
