package fr.titouz.gamewatch.emulateur.view.common;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class RedButtonPanel extends JPanel{

	private static RedButtonPanel instance;
	private int x,y,diameter;

	private RedButtonPanel() {
		x = this.getWidth()/2;
		y = this.getHeight()/2;
		diameter = this.getWidth();
	}

	public static synchronized RedButtonPanel getInstance() {
		if (null == instance) {
			instance = new RedButtonPanel();
		}
		return instance;
	}
	
	public RedButtonPanel init() {
		this.setOpaque(false);
		this.setLayout(null);
		
		return this;
	}
	
	public void painComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D)g;
		Ellipse2D.Double circle = new Ellipse2D.Double(x,y,diameter,diameter);
		g2d.setBackground(Color.red);
		g2d.fill(circle);
	}
}


