package fr.titouz.gamewatch.modeleur.vues.composants;

import fr.titouz.gamewatch.modeleur.modele.GTransition;
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
	
	private Sprite spriteEnCours = null;

	private Sprite spriteDestination = null;

	/**
	 * Default constructor of
	 * <code>SequenceSprite</code>.
	 */
	public SequenceSprite(int typeSprites) {
		this.typeSprites = typeSprites;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				sourisRelachee(e);
			}
		});
		
		
	}
	
	public void sourisRelachee(MouseEvent e) {
		if (spriteEnCours == null) {
			spriteEnCours = getClickedSprite(e.getPoint());
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
							spriteDestination = null;
						}
						
						@Override
						public void popupMenuCanceled(PopupMenuEvent e) {
							
						}
					});
					
					menu.show(this, (int) e.getPoint().getX(), (int) e.getPoint().getY());
					
				}
				else {
					Jeu.getInstance().ajouterSequence(new GTransition(spriteEnCours, spriteDestination, "auto"));
				}
				
				
				spriteEnCours = null;
			}
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
		Sprite sp = null;
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
					return sp;
				}
			}
		}
		return null;
	}
	
	public void actionPopUpGauche() {
		Jeu.getInstance().ajouterSequence(new GTransition(spriteEnCours, spriteDestination, "gauche"));
		
	}
	
	public void actionPopUpDroit() {
		
		Jeu.getInstance().ajouterSequence(new GTransition(spriteEnCours, spriteDestination, "droite"));
	}
}
