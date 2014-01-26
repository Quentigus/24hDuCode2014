package fr.titouz.gamewatch.modeleur.vues.composants.fond;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import fr.titouz.gamewatch.modeleur.vues.composants.PanelImage;


public class DecoupeurFond extends JPanel {
	
	private static final long serialVersionUID = 6913807389734526730L;
	private PanelImage panel;
	private Point click;
	
	public DecoupeurFond(BufferedImage pImage) {
		this.setLayout(new BorderLayout());
		
		this.panel = new PanelImage(pImage);
		this.panel.setAfficherEcran(true);
		
		this.panel.ajouterListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				click = e.getPoint();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				panel.setDecalages(click, e.getPoint());
				panel.resetAncienPtDrag();
			}
		});
		
		this.panel.ajouterListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				panel.setDecalages(click, e.getPoint());
			}
		});


		this.add(this.panel, BorderLayout.CENTER);
	}
}
