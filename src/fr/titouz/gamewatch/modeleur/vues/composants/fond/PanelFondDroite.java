package fr.titouz.gamewatch.modeleur.vues.composants.fond;

import java.awt.GridLayout;

import javax.swing.JPanel;

import fr.titouz.gamewatch.modeleur.vues.composants.PanelParcourir;
import fr.titouz.gamewatch.modeleur.vues.composants.PanelSlider;
import fr.titouz.gamewatch.modeleur.vues.composants.fond.listeners.ChargementImageListener;
import fr.titouz.gamewatch.modeleur.vues.composants.fond.listeners.DecalageHorizontalListener;
import fr.titouz.gamewatch.modeleur.vues.composants.fond.listeners.DecalageVerticalListener;
import fr.titouz.gamewatch.modeleur.vues.composants.fond.listeners.EchelleListener;
import fr.titouz.gamewatch.modeleur.vues.composants.fond.listeners.OpaciteListener;

public class PanelFondDroite extends JPanel {

	private static final long serialVersionUID = 2266422393683511519L;
	private PanelSlider decalageH;
	private PanelSlider decalageV;
	private PanelSlider echelle;
	private PanelSlider opacite;
	
	
	
	public PanelFondDroite() {
		this.decalageH = new PanelSlider("Décalage horizontal", new DecalageHorizontalListener());
		this.decalageV = new PanelSlider("Décalage vertical", new DecalageVerticalListener());
		this.echelle = new PanelSlider("Echelle", 0, 200, 100, new EchelleListener());
		this.opacite = new PanelSlider("Opacité", 0, 100, 20, new OpaciteListener());
				
		this.setLayout(new GridLayout(5, 1));
		this.add(new PanelParcourir(new ChargementImageListener()));
		this.add(this.decalageH);
		this.add(this.decalageV);
		this.add(this.echelle);
		this.add(this.opacite);
	}
}
