package fr.titouz.gamewatch.modeleur.vues;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import fr.titouz.gamewatch.modeleur.vues.composants.DecoupeurSprites;
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
		tab.addTab("Gérer les cinématiques", new JPanel());*/
		
		tab.addTab("ghjgh", new DecoupeurSprites());
		tab.addTab("qgo", new PositionnementSprite());
		
		this.setContentPane(tab);
		this.validate();
		this.pack();
		this.revalidate();
	}
}