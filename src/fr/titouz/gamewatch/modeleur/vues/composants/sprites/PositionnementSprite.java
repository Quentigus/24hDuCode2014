package fr.titouz.gamewatch.modeleur.vues.composants.sprites;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

import fr.titouz.gamewatch.modeleur.vues.composants.PanelChoixStripes;
import fr.titouz.gamewatch.modeleur.vues.composants.PanelEcran;

public class PositionnementSprite extends JPanel {

	private static final long serialVersionUID = 8316331718829125719L;

	public PositionnementSprite() {
		this.setLayout(new BorderLayout());
		
		this.add(new PanelChoixStripes(), BorderLayout.WEST);
		this.add(new PanelEcran(new MouseAdapter() {}), BorderLayout.CENTER);
	}
}
