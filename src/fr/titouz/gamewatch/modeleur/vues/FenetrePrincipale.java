package fr.titouz.gamewatch.modeleur.vues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.util.LinkedHashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import fr.titouz.gamewatch.modeleur.modele.Jeu;
import fr.titouz.gamewatch.modeleur.vues.composants.DecoupeurSprites;
import fr.titouz.gamewatch.modeleur.vues.composants.PanelConfigurationFond;
import fr.titouz.gamewatch.modeleur.vues.composants.PanelImage;
import fr.titouz.gamewatch.modeleur.vues.composants.PositionnementSprite;
import fr.titouz.gamewatch.tools.ImagesHelper;

public class FenetrePrincipale extends JFrame {

	private static final long serialVersionUID = 3189376456185578145L;

	private LinkedHashMap<JPanel, String> mapEtapes;

	private JPanel panelPrincipal;

	private int indexEtape = 0;

	private JButton boutSuivant;

	public FenetrePrincipale() {
		try {

			this.mapEtapes = new LinkedHashMap<>();

			
			mapEtapes.put(new JPanel(), "test1");
			mapEtapes.put(new JPanel(), "test2");

			this.setSize(new Dimension(1200, 800));
			this.setMinimumSize(new Dimension(1000, 600));
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);

			this.setLayout(new BorderLayout());
			JLabel topLabel = new JLabel("Assistant création de jeu Titz & Watch");
			topLabel.setIcon(ImagesHelper.getIcon("ressources/wizard-icon.png"));
			topLabel.setHorizontalAlignment(JLabel.CENTER);

			this.add(topLabel, BorderLayout.NORTH);

			JList listeGauche = new JList(new Vector<String>(mapEtapes.values()));

			this.add(listeGauche, BorderLayout.WEST);
			panelPrincipal = new JPanel(new BorderLayout());

			this.add(panelPrincipal, BorderLayout.CENTER);

			JPanel panelBas = new JPanel(new FlowLayout(FlowLayout.RIGHT));

			boutSuivant = new JButton("Suivant");

			panelBas.add(boutSuivant);

			boutSuivant.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					appuiSuivant();
				}
			});

			this.add(panelBas, BorderLayout.SOUTH);


			this.setVisible(true);
			this.revalidate();
		} catch (MalformedURLException ex) {
			Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void appuiSuivant() {
		JPanel aAfficher = null;
		indexEtape++;
		
		switch (indexEtape) {
		case 1:
			aAfficher =  new DecoupeurSprites();
			break;
		case 2:
			aAfficher = new PanelConfigurationFond();
			break;
		case 3 :
			aAfficher = new PositionnementSprite();
			break;
		case 4: 
			aAfficher = new PositionnementSprite();
			break;
		case 5:
			aAfficher = new PositionnementSprite();
			break;
		case 6:
			aAfficher = new PanelImage();
			break;
		}
		this.panelPrincipal.removeAll();
		
		if (aAfficher != null) {
			this.panelPrincipal.add(aAfficher, BorderLayout.CENTER);
		}
		else {
			FileOutputStream fichier;
			try {
				fichier = new FileOutputStream("test.titz");
				ObjectOutputStream oos = new ObjectOutputStream(fichier);
				oos.writeObject(Jeu.getInstance());
				oos.flush();
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.revalidate();
		this.repaint();
	}
}
