package fr.titouz.gamewatch.modeleur.vues.composants.fond.listeners;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DecalageHorizontalListener implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent e) {
		System.out.println("Décalage horizontal : " + ((JSpinner)e.getSource()).getValue());
	}

}
