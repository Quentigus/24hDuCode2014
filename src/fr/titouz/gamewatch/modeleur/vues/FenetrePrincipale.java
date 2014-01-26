package fr.titouz.gamewatch.modeleur.vues;

import fr.titouz.gamewatch.modeleur.vues.composants.fond.DecoupeurFond;
import fr.titouz.gamewatch.modeleur.vues.composants.DecoupeurSprites;
import javax.swing.JFrame;

import fr.titouz.gamewatch.modeleur.vues.composants.DecoupeurSprites;
import fr.titouz.gamewatch.modeleur.vues.composants.fond.DecoupeurFond;
import fr.titouz.gamewatch.modeleur.vues.composants.sprites.PositionnementSprite;
import fr.titouz.gamewatch.tools.ImagesHelper;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class FenetrePrincipale extends JFrame {

	private static final long serialVersionUID = 3189376456185578145L;

	public FenetrePrincipale() {
		try {
			this.setSize(new Dimension(1200,800));
			this.setMinimumSize(new Dimension(1000,600));
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			this.setLayout(new GridBagLayout());
			
			GridBagConstraints c = new GridBagConstraints();
			
			c.gridx = 0;
			c.gridy = 0;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weighty = 0.1;
			
			JLabel topLabel = new JLabel("Assistant création de jeu Titz & Watch");
			topLabel.setIcon(ImagesHelper.getIcon("wizard-icon.png"));
			
			this.add(topLabel,c);
			
			this.setVisible(true);
			this.revalidate();
		} catch (MalformedURLException ex) {
			Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
