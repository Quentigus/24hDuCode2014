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

package fr.titouz.gamewatch.modeleur.vues.composants;

import fr.titouz.gamewatch.jeu.ContextJeu;
import fr.titouz.gamewatch.jeu.Etat;
import fr.titouz.gamewatch.jeu.Sequence;
import fr.titouz.gamewatch.jeu.Transition;
import fr.titouz.gamewatch.jeu.transitions.TransitionSimple;
import fr.titouz.gamewatch.jeu.transitions.TransitionToucheDroite;
import fr.titouz.gamewatch.jeu.transitions.TransitionToucheGauche;
import fr.titouz.gamewatch.modeleur.modele.Jeu;
import fr.titouz.gamewatch.modeleur.modele.Sprite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

/**
 *
 * @author Bastien Andru <bastien.andru@gmail.com>
 */
public class SequenceSprite extends JPanel {
	
	private int typeSprites;
	
	private Sprite spriteEnCours;
	
	private Sprite spriteSource;

	private Sprite spriteDestination;
	
	private Sequence sequenceCourante;
	
	private ContextJeu contextJeu;//TODO Ceci est un patch en attendant la gestion du contexte de jeu.

	/**
	 * Default constructor of
	 * <code>SequenceSprite</code>.
	 */
	public SequenceSprite(int typeSprites) {
		this.typeSprites = typeSprites;
		this.sequenceCourante = new Sequence();//TODO Ceci est un patch en attentant la possibilité de créer ses propres séquences
		this.contextJeu = new ContextJeu();//TODO Ceci est un patch en attendant la gestion du contexte de jeu.
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				sourisRelachee(e);
			}
		});
		
		Jeu.getInstance().ajouterSequence(sequenceCourante);
		
	}
	
	public void sourisRelachee(MouseEvent e) {
		if (spriteEnCours == null) {
			spriteEnCours = getClickedSprite(e.getPoint());
			spriteSource = spriteEnCours;
			System.out.println("Res : " + spriteEnCours);
		}
		else {
			spriteDestination = getClickedSprite(e.getPoint());
			if (spriteDestination != null) {
				if (typeSprites == 1) {
					JMenuItem itGauche = new JMenuItem("Action gauche");
					itGauche.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							actionPopUpGauche();
						}
					});
					JMenuItem itDroite = new JMenuItem("Action droite");
					itDroite.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							actionPopUpDroit();
						}
					});
					JPopupMenu menu = new JPopupMenu();
					menu.add(itGauche);
					menu.add(itDroite);
					
					menu.addPopupMenuListener(new PopupMenuListener() {
						@Override
						public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
						}
						
						@Override
						public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
							spriteEnCours = null;
						}
						
						@Override
						public void popupMenuCanceled(PopupMenuEvent e) {
							
						}
					});
					
					menu.show(this, (int) e.getPoint().getX(), (int) e.getPoint().getY());
					
				}
				else {// Transition automatique d'un sprite à l'autre
					System.out.println("Création d'une transition automatique");
					
					/* Association du sprite de début de transition à un état
					 * s'il n'en avait pas.
					 */
					if(!spriteSource.hasEtat()) {
						spriteSource.setEtat(new Etat());
					}
					
					/* Association du sprite de fin de transition à un état
					 * s'il n'en avait pas.
					 */
					if(!spriteDestination.hasEtat()) {
						spriteDestination.setEtat(new Etat());
					}
					
					// Ajout de l'état initial de la séquence courante si elle est vide
					if(sequenceCourante.getEtatInitial() == null) {
						sequenceCourante.setEtatInitial(spriteSource.getEtat());
						//Initialisation de la séquence
						sequenceCourante.getEtatInitial().setActif(true);
						sequenceCourante.getEtatsCourants().add(sequenceCourante.getEtatInitial());
					}
					// Traitement du cas de transition classique
					if(spriteSource != spriteDestination) {
						//Création de la nouvelle transition
						Transition trans = new TransitionSimple(sequenceCourante, spriteSource.getEtat());
						trans.getEtatSortie().add(spriteDestination.getEtat());
					}
					else {// Traitement du cas de transition sur le même sprite
						// TODO définir le comportement : exception ou inversion de visibilité ?
					}
				}
			}
			spriteEnCours = null;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(Jeu.getInstance().getFond(), null, 0, 0);
		
		if (typeSprites == 1) {
			for (Sprite s : Jeu.getInstance().getLesPersonnages()) {
				g2d.drawImage(s.getImage(), null, (int) s.getCoordonnees().getX(), (int) s.getCoordonnees().getY());
			}
		}
		else {
			for (Sprite s : Jeu.getInstance().getLesEnnemies()) {
				g2d.drawImage(s.getImage(), null, (int) s.getCoordonnees().getX(), (int) s.getCoordonnees().getY());
			}
		}
	}
	
	public Sprite getClickedSprite(Point pt) {
		if (typeSprites == 1) {
			for (Sprite s : Jeu.getInstance().getLesPersonnages()) {
				Rectangle r = new Rectangle((int) s.getCoordonnees().getX(), (int) s.getCoordonnees().getY(), s.getImage().getWidth(), s.getImage().getHeight());
				
				System.out.println(r);
				System.out.println(pt);
				if (r.contains(pt)) {
					System.out.println("ret");
					return s;
				}
			}
		}
		else {
			for (Sprite s : Jeu.getInstance().getLesEnnemies()) {
				Rectangle r = new Rectangle((int) s.getCoordonnees().getX(), (int) s.getCoordonnees().getY(), s.getImage().getWidth(), s.getImage().getHeight());
				if (r.contains(pt)) {
					return s;
				}
			}
		}
		return null;
	}
	
	public void actionPopUpGauche() {
		System.out.println("Création d'une transition sur la touche gauche");
		/* Association du sprite de début de transition à un état
		 * s'il n'en avait pas.
		 */
		if(!spriteSource.hasEtat()) {
			spriteSource.setEtat(new Etat());
		}
		
		/* Association du sprite de fin de transition à un état
		 * s'il n'en avait pas.
		 */
		if(!spriteDestination.hasEtat()) {
			spriteDestination.setEtat(new Etat());
		}
		
		// Ajout de l'état initial de la séquence courante si elle est vide
		if(sequenceCourante.getEtatInitial() == null) {
			sequenceCourante.setEtatInitial(spriteSource.getEtat());
			//Initialisation de la séquence
			sequenceCourante.getEtatInitial().setActif(true);
			sequenceCourante.getEtatsCourants().add(sequenceCourante.getEtatInitial());
		}
		// Traitement du cas de transition classique
		if(spriteSource != spriteDestination) {
			//Création de la nouvelle transition
			Transition trans = new TransitionToucheGauche(contextJeu, sequenceCourante, spriteSource.getEtat());
			trans.getEtatSortie().add(spriteDestination.getEtat());
		}
		else {// Traitement du cas de transition sur le même sprite
			// TODO définir le comportement : exception ou inversion de visibilité ?
		}
	}
	
	public void actionPopUpDroit() {
		System.out.println("Création d'une transition sur la touche droite");
		/* Association du sprite de début de transition à un état
		 * s'il n'en avait pas.
		 */
		if(!spriteSource.hasEtat()) {
			spriteSource.setEtat(new Etat());
		}
		
		/* Association du sprite de fin de transition à un état
		 * s'il n'en avait pas.
		 */
		if(!spriteDestination.hasEtat()) {
			spriteDestination.setEtat(new Etat());
		}
		
		// Ajout de l'état initial de la séquence courante si elle est vide
		if(sequenceCourante.getEtatInitial() == null) {
			sequenceCourante.setEtatInitial(spriteSource.getEtat());
			//Initialisation de la séquence
			sequenceCourante.getEtatInitial().setActif(true);
			sequenceCourante.getEtatsCourants().add(sequenceCourante.getEtatInitial());
		}
		// Traitement du cas de transition classique
		if(spriteSource != spriteDestination) {
			//Création de la nouvelle transition
			Transition trans = new TransitionToucheDroite(contextJeu, sequenceCourante, spriteSource.getEtat());
			trans.getEtatSortie().add(spriteDestination.getEtat());
		}
		else {// Traitement du cas de transition sur le même sprite
			// TODO définir le comportement : exception ou inversion de visibilité ?
		}
	}
}
