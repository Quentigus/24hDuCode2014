package fr.titouz.gamewatch.modeleur.vues;

import fr.titouz.gamewatch.modeleur.vues.composants.DecoupeurFond;
import fr.titouz.gamewatch.modeleur.vues.composants.DecoupeurSprites;
import javax.swing.JFrame;

/**
 *
 * @author Bastien Andru <bastien.andru@gmail.com>
 */
public class FenetrePrincipale extends JFrame{

	/**
	 * Default constructor of <code>FenetrePrincipale</code>.
	 */
	public FenetrePrincipale() {
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setContentPane(new DecoupeurSprites());
		this.revalidate();
	}
}