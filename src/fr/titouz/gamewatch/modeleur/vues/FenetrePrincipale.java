package fr.titouz.gamewatch.modeleur.vues;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

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
		tab.addTab("ghjgh", null);
		tab.addTab("ghjgh", null);
		tab.addTab("ghjgh", null);
		this.setContentPane(tab);
	}
}