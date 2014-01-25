package fr.titouz.gamewatch.modeleur.vues;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import fr.titouz.gamewatch.modeleur.vues.composants.sprites.PositionnementSprite;

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
		JTabbedPane tab = new JTabbedPane(JTabbedPane.LEFT);
		
		/*tab.addTab("Selectionner une image de fond", new DecoupeurFond());
		tab.addTab("Découper les sprites", new JPanel());
		tab.addTab("Positionner les objets fixes", new PositionnementSprite());
		tab.addTab("Positionner les emplacements personnage", new PositionnementSprite());
		tab.addTab("Positionner les emplacements ennemi", new PositionnementSprite());
		tab.addTab("Gérer les cinématiques", new JPanel());
		
		this.setContentPane(tab);*/
		
		this.setContentPane(new PositionnementSprite());
		this.validate();
		this.pack();
	}
}