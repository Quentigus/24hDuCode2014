package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PositionnementSprite extends JPanel {

	private static final long serialVersionUID = 8316331718829125719L;
	private PanelChoixStripes panelStripes;
	private PanelEcran panelEcran;
	
	public PositionnementSprite() {
		this.setLayout(new BorderLayout());
		
		this.panelStripes = new PanelChoixStripes();
		JScrollPane scroll = new JScrollPane(this.panelStripes);
		
		this.panelEcran = new PanelEcran(new MouseAdapter() {});
		
		this.add(scroll, BorderLayout.WEST);
		this.add(this.panelEcran, BorderLayout.CENTER);
	}
}
