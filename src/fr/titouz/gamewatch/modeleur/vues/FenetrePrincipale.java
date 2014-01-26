package fr.titouz.gamewatch.modeleur.vues;

import fr.titouz.gamewatch.modeleur.vues.composants.ChargerFond;
import fr.titouz.gamewatch.modeleur.vues.composants.DecoupeurFond;
import javax.swing.JFrame;

import fr.titouz.gamewatch.modeleur.vues.composants.DecoupeurSprites;
import fr.titouz.gamewatch.modeleur.vues.composants.PositionnementSprite;
import fr.titouz.gamewatch.tools.ImagesHelper;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.TreeNode;

public class FenetrePrincipale extends JFrame {

	private static final long serialVersionUID = 3189376456185578145L;
	private LinkedHashMap<JPanel,String> mapEtapes;
	private JPanel panelPrincipal;
	private int indexEtape = -1;
	private JButton boutSuivant;
	
	public FenetrePrincipale() {
		try {
			
			this.mapEtapes = new LinkedHashMap<>();
			
			mapEtapes.put(new DecoupeurSprites(),"1");
		mapEtapes.put(new ChargerFond(),"2.1");
		mapEtapes.put(new DecoupeurFond(),"2.2");
		mapEtapes.put(new PositionnementSprite(),"3");
		mapEtapes.put(new PositionnementSprite(),"4");
		mapEtapes.put(new PositionnementSprite(),"5");
		mapEtapes.put(new JPanel(),"6");
		mapEtapes.put(new JPanel(),"7");
			
			
			mapEtapes.put(new JPanel(), "test1");
			mapEtapes.put(new JPanel(), "test2");
			
			this.setSize(new Dimension(1200, 800));
			this.setMinimumSize(new Dimension(1000, 600));
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);

			this.setLayout(new GridBagLayout());

			GridBagConstraints c = new GridBagConstraints();

			c.gridx = 0;
			c.gridy = 0;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weighty = 1;
			c.weightx = 10;
			c.anchor = GridBagConstraints.CENTER;

			JLabel topLabel = new JLabel("Assistant création de jeu Titz & Watch");
			topLabel.setIcon(ImagesHelper.getIcon("ressources/wizard-icon.png"));
			topLabel.setHorizontalAlignment(JLabel.CENTER);

			this.add(topLabel,c);
			
			c.gridx = 0;
			c.gridy = 1;
			c.fill = GridBagConstraints.BOTH;
			c.weighty = 8;
			c.weightx = 1;
			c.anchor = GridBagConstraints.WEST;
			
			JList listeGauche = new JList(new Vector<String>(mapEtapes.values()));
			
			this.add(listeGauche,c);
			
			panelPrincipal = new JPanel(new BorderLayout());
			
			panelPrincipal.setOpaque(true);
			panelPrincipal.setBackground(Color.red);
			
			panelPrincipal.add(new JLabel("Bienvenue"));
			
			c.gridx = 1;
			c.gridy = 1;
			c.fill = GridBagConstraints.BOTH;
			c.weighty = 8;
			c.weightx = 39;
			c.anchor = GridBagConstraints.WEST;
			
			this.add(panelPrincipal,c);
			
			JPanel panelBas = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			
			boutSuivant = new JButton("Suivant");
			
			panelBas.add(boutSuivant);
			
			boutSuivant.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					appuiSuivant();
				}
			});
			
			c.gridx = 0;
			c.gridy = 2;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weighty = 1;
			c.weightx = 1;
			
			this.add(panelBas,c);
			
			this.setVisible(true);
			this.revalidate();
		} catch (MalformedURLException ex) {
			Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	private void appuiSuivant(){
		indexEtape++;
		this.panelPrincipal.removeAll();
		this.panelPrincipal.add(new LinkedList<JPanel>(mapEtapes.keySet()).get(indexEtape),BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}
}