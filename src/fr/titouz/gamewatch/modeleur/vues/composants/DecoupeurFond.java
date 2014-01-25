package fr.titouz.gamewatch.modeleur.vues.composants;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.titouz.gamewatch.modeleur.vues.composants.fond.listeners.DecalageHorizontalListener;
import fr.titouz.gamewatch.modeleur.vues.composants.fond.listeners.DecalageVerticalListener;
import fr.titouz.gamewatch.modeleur.vues.composants.fond.listeners.EchelleListener;
import fr.titouz.gamewatch.modeleur.vues.composants.fond.listeners.OpaciteListener;

public class DecoupeurFond {
	private JSpinner spinDecalHorizontal;
	private JSpinner spinDecalVertical;
	private JSpinner spinEchelle;
	private JSpinner spinOpacite;
	
	/**
	 * Constructeur par défaut.
	 */
	public DecoupeurFond() {
		
	}
	
	/**
	 * 
	 * @return
	 */
	private JSpinner getGroupeDecalHorizontal() {
		if (this.spinDecalHorizontal == null) {
			this.spinDecalHorizontal = new JSpinner();
			this.spinDecalHorizontal.addChangeListener(new DecalageHorizontalListener());
		}
		return this.spinDecalHorizontal;
	}
	
	/**
	 * 
	 * @return
	 */
	private JSpinner getGroupeDecalVertical() {
		if (this.spinDecalVertical == null) {
			this.spinDecalVertical = new JSpinner();
			this.spinDecalVertical.addChangeListener(new DecalageVerticalListener());
		}
		return this.spinDecalVertical;
	}
	/**
	 * 
	 * @return
	 */
	private JSpinner getGroupeEchelle() {
		if (this.spinEchelle == null) {
			this.spinEchelle = new JSpinner();
			this.spinEchelle.addChangeListener(new EchelleListener());
		}
		return this.spinEchelle;
	}
	
	/**
	 * 
	 * @return
	 */
	private JSpinner getGroupeOpacite() {
		if (this.spinOpacite == null) {
			this.spinOpacite = new JSpinner();
			this.spinOpacite.addChangeListener(new OpaciteListener());
		}
		return this.spinOpacite;
	}
}
