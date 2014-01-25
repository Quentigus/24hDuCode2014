package fr.titouz.gamewatch.modeleur.vues;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import fr.titouz.gamewatch.modeleur.vues.composants.DecoupeurSprites;
import fr.titouz.gamewatch.modeleur.vues.composants.fond.DecoupeurFond;
import fr.titouz.gamewatch.modeleur.vues.composants.sprites.PositionnementSprite;

public class FenetrePrincipale extends JFrame {

	private static final long serialVersionUID = 3189376456185578145L;

	public FenetrePrincipale() {
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		JTabbedPane tab = new JTabbedPane(JTabbedPane.LEFT);
		
		/*tab.addTab("Selectionner une image de fond", new DecoupeurFond());
		tab.addTab("Découper les sprites", new JPanel());
		tab.addTab("Positionner les objets fixes", new PositionnementSprite());
		tab.addTab("Positionner les emplacements personnage", new PositionnementSprite());
		tab.addTab("Positionner les emplacements ennemi", new PositionnementSprite());
		tab.addTab("Gérer les cinématiques", new JPanel());*/
		
		tab.addTab("ghjgh", new DecoupeurSprites());
		tab.addTab("qgo - fond", new DecoupeurFond());
		tab.addTab("qgo - pos sprites", new PositionnementSprite());
		
		this.setContentPane(tab);
		this.validate();
		this.pack();
		this.revalidate();
	}
}