package fr.titouz.gamewatch.modeleur.vues.composants;

import fr.titouz.gamewatch.modeleur.modele.Jeu;
import fr.titouz.gamewatch.modeleur.modele.Sprite;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class PositionnementSprite extends JPanel {

	private static final long serialVersionUID = 8316331718829125719L;
	private PanelChoixStripes panelStripes;
	private PanelEcran panelEcran;
	private Sprite spriteEnCours = null;
	private int typeSprite;
	
	public PositionnementSprite(int typeSprite) {
		this.typeSprite = typeSprite;
		this.setLayout(new BorderLayout());
		
		this.panelStripes = new PanelChoixStripes();
		JScrollPane scroll = new JScrollPane(this.panelStripes);
		
		this.panelEcran = new PanelEcran(typeSprite);
		
		panelEcran.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				sourisRelachee(e);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				sourisAppuyee(e);
			}
		
			
		});
		
		
		panelEcran.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				super.mouseDragged(e);
				sourisBougee(e);
			}
		
			
			
		});
		
		
		
		this.add(scroll, BorderLayout.WEST);
		this.add(this.panelEcran, BorderLayout.CENTER);
	}
	
	public void sourisAppuyee(MouseEvent e){
		System.out.println("app");
		BufferedImage img = panelStripes.getSelectedSprite();
		if(!(img == null)){
			Point ptConvEcr = e.getPoint();
			SwingUtilities.convertPointToScreen(ptConvEcr, panelEcran);
			Point ptConvPanImage = ptConvEcr;
			SwingUtilities.convertPointFromScreen(ptConvPanImage, panelEcran.getEcran());
			spriteEnCours = new Sprite(ptConvPanImage, img);
			if(typeSprite ==1){
				System.out.println("ajout fixe");
				Jeu.getInstance().getLesFixes().add(spriteEnCours);
			}else if(typeSprite ==2){
				Jeu.getInstance().getLesPersonnages().add(spriteEnCours);
			} else{
				Jeu.getInstance().getLesEnnemies().add(spriteEnCours);
			}
		}
		this.repaint();
	} 
	
	public void sourisRelachee(MouseEvent e){
		System.out.println("rel");
		spriteEnCours = null;
		this.repaint();
	} 
	
	public void sourisBougee(MouseEvent e){
		System.out.println("bou");
		Point ptConvEcr = e.getPoint();
			SwingUtilities.convertPointToScreen(ptConvEcr, panelEcran);
			Point ptConvPanImage = ptConvEcr;
			SwingUtilities.convertPointFromScreen(ptConvPanImage, panelEcran.getEcran());
		spriteEnCours.setCoordonnees(ptConvPanImage);
		this.repaint();
	} 
}
