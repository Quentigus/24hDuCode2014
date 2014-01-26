package fr.titouz.gamewatch.modeleur.vues.composants;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JPanel;

import fr.titouz.gamewatch.modeleur.modele.Jeu;


public class DecoupeurFond extends JPanel {
	
	private static final long serialVersionUID = 6913807389734526730L;
	private PanelImage panel;
	private Point click;
	
	public DecoupeurFond() {
		this.setLayout(new BorderLayout());
		
		this.panel = new PanelImage();
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
				sauvegarderImage();
			}
		});
		
		this.panel.ajouterListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseDragged(MouseEvent e) {
				panel.setDecalages(click, e.getPoint());
			}
		});

		this.add(this.panel, BorderLayout.CENTER);
	}
	
	public void updateImage() {
		this.panel.setImage(Jeu.getInstance().getFond());
	}
	
	public void sauvegarderImage() {
		Jeu.getInstance().setFond(this.panel.getImage());
	}
}
