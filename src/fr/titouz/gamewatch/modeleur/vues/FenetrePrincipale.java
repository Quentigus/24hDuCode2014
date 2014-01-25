package fr.titouz.gamewatch.modeleur.vues;

import fr.titouz.gamewatch.modeleur.vues.composants.DecoupeurFond;
import fr.titouz.gamewatch.modeleur.vues.composants.DecoupeurSprites;
import javax.swing.JFrame;

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
		this.setContentPane(new DecoupeurSprites());
		this.revalidate();
	}
}
