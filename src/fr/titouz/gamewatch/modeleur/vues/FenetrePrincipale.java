/* Copyright ANDRU Bastien, CARRE, Gaël DUROY Adrien, GOSSELIN Quentin, JARROT Kathleen
 * (25/01/2014)
 * This file is part of Titz & Watch.
 * 
 * Titz & Watch is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * Titz & Watch is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with Titz & Watch.  
 * If not, see <http://www.gnu.org/licenses/>.
 */

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
import fr.titouz.gamewatch.modeleur.vues.composants.SequenceSprite;
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
			JLabel topLabel = new JLabel("Assistant création de jeu Titz & Watch");
			topLabel.setFont(new Font(topLabel.getFont().getFontName(), Font.BOLD, 20));
			topLabel.setIcon(ImagesHelper.getIcon("ressources/wizard-icon.png"));
			topLabel.setHorizontalAlignment(JLabel.CENTER);

			this.add(topLabel, BorderLayout.NORTH);

			panelPrincipal = new JPanel(new BorderLayout());

			this.add(panelPrincipal, BorderLayout.CENTER);

			this.labelEtape = new JLabel("Bienvenue sur le générateur de Titz & Watch");
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
			this.labelEtape.setText("Etape 1 : Découpage des icônes");
			aAfficher =  new DecoupeurSprites();
			break;
		case 2:
			this.labelEtape.setText("Etape 2 : Chargement du fond");
			aAfficher = new PanelConfigurationFond();
			break;
		case 3 :
			this.labelEtape.setText("Etape 3 : Positionnement des icônes des objets fixes");
			aAfficher = new PositionnementSprite(1);
			break;
		case 4: 
			this.labelEtape.setText("Etape 4 : Positionnement des icônes du personnage");
			aAfficher = new PositionnementSprite(2);
			break;
		case 5:
			this.labelEtape.setText("Etape 5 : Positionnement de icônes des ennemis");
			aAfficher = new PositionnementSprite(3);
			break;
		case 6:
			this.labelEtape.setText("Etape 6 : Définition des séquences des personnages");
			aAfficher = new SequenceSprite(1);
			break;
		case 7:
			this.labelEtape.setText("Etape 7 : Définition des séquences des ennemis");
			aAfficher = new SequenceSprite(2);
			break;
		case 8:
			//try {
				this.labelEtape.setText("Etape 8 : Sauvegarde des informations");
				aAfficher = new PanelImage(Jeu.getInstance().getFond());//ImageIO.read(new File("ressources/screen_home.png")));
				FileOutputStream fichier;
				try {
					fichier = new FileOutputStream("C:\\titzwatch\\nouveau_jeu.titz");
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
			/*} catch (IOException e1) {
				e1.printStackTrace();
			}*/
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
