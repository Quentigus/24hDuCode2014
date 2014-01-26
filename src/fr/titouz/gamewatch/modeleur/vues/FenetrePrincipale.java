package fr.titouz.gamewatch.modeleur.vues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.titouz.gamewatch.modeleur.modele.Jeu;
import fr.titouz.gamewatch.modeleur.vues.composants.DecoupeurSprites;
import fr.titouz.gamewatch.modeleur.vues.composants.PanelConfigurationFond;
import fr.titouz.gamewatch.modeleur.vues.composants.PanelImage;
import fr.titouz.gamewatch.modeleur.vues.composants.PositionnementSprite;
import fr.titouz.gamewatch.tools.ImagesHelper;

public class FenetrePrincipale extends JFrame {

	private static final long serialVersionUID = 3189376456185578145L;

	private JPanel panelPrincipal;

	private int indexEtape = 0;

	private JButton boutSuivant;
	private JLabel labelEtape;

	public FenetrePrincipale() {
		try {
			this.setSize(new Dimension(1200, 800));
			this.setMinimumSize(new Dimension(1000, 600));
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);

			this.setLayout(new BorderLayout());
			JLabel topLabel = new JLabel("Assistant cr�ation de jeu Titz & Watch");
			topLabel.setFont(new Font(topLabel.getFont().getFontName(), Font.BOLD, 20));
			topLabel.setIcon(ImagesHelper.getIcon("ressources/wizard-icon.png"));
			topLabel.setHorizontalAlignment(JLabel.CENTER);

			this.add(topLabel, BorderLayout.NORTH);

			panelPrincipal = new JPanel(new BorderLayout());

			this.add(panelPrincipal, BorderLayout.CENTER);

			this.labelEtape = new JLabel("Bienvenue sur le g�n�rateur de Titz & Watch");
			this.labelEtape.setFont(new Font(this.labelEtape.getFont().getFontName(), Font.BOLD, 17));
			
			this.panelPrincipal.add(this.labelEtape, BorderLayout.NORTH);
			
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
			this.labelEtape.setText("Etape 1 : D�coupage des ic�nes");
			aAfficher =  new DecoupeurSprites();
			break;
		case 2:
			this.labelEtape.setText("Etape 2 : Chargement du fond");
			aAfficher = new PanelConfigurationFond();
			break;
		case 3 :
			this.labelEtape.setText("Etape 3 : Positionnement des ic�nes des objets fixes");
			aAfficher = new PositionnementSprite(1);
			break;
		case 4: 
			this.labelEtape.setText("Etape 4 : Positionnement des ic�nes du personnage");
			aAfficher = new PositionnementSprite(2);
			break;
		case 5:
			this.labelEtape.setText("Etape 5 : Positionnement de ic�nes des ennemis");
			aAfficher = new PositionnementSprite(3);
			break;
		case 6:
			try {
				this.labelEtape.setText("Etape 6 : Sauvegarde des informations");
				aAfficher = new PanelImage(ImageIO.read(new File("ressources/screen_home.png")));
				FileOutputStream fichier;
				try {
					fichier = new FileOutputStream("test.titz");
					ObjectOutputStream oos = new ObjectOutputStream(fichier);
					oos.writeObject(Jeu.getInstance());
					oos.flush();
					oos.close();
					
					this.boutSuivant.setVisible(false);
				} catch (FileNotFoundException e) {
					Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, e);
				} catch (IOException e) {
					Logger.getLogger(FenetrePrincipale.class.getName()).log(Level.SEVERE, null, e);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		}
		this.panelPrincipal.removeAll();
		this.panelPrincipal.add(this.labelEtape, BorderLayout.NORTH);
		
		if (aAfficher != null) {
			this.panelPrincipal.add(aAfficher, BorderLayout.CENTER);
		}
		this.revalidate();
		this.repaint();
	}
}
