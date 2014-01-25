package fr.titouz.gamewatch.modeleur.vues;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
		JPanel pan = new JPanel(new BorderLayout());
		JTabbedPane tab = new JTabbedPane(JTabbedPane.LEFT);
		tab.addTab("ghjgh", pan);
		this.setContentPane(tab);
		
	}
}